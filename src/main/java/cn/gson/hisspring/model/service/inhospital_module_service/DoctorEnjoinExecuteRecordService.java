package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.*;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.StaffMapper;
import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YfDispensingMapper;
import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.DrugVo;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientPayObjVo;
import cn.gson.hisspring.model.pojos.pojos_vo.ZyHCindConsumables;
import cn.gson.hisspring.model.pojos.pojos_vo.ZyYfDrugInventoryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 执行医嘱service
 */
@Service
@Transactional
public class DoctorEnjoinExecuteRecordService {

    @Autowired
    DoctorEnjoinDetailsMapper dedm;//医嘱详情mapper

    @Autowired
    DoctorEnjoinExecuteRecordMapper deerm;//医嘱执行mapper

    @Autowired
    PatientBaseMapper pbm;//病人mapper

    @Autowired
    YfDrugInventoryVoMapper ydivm;//药房mapper

    @Autowired
    YfDispensingMapper ydm;//发药记录mapper

    @Autowired
    DrugPharmacyMapper dpms;//科室药品库存mapper

    @Autowired
    ZyDrugInFormationMapper difm;//药品mapper

    @Autowired
    StaffMapper sm;//员工mapper

    @Autowired
    ZyHcIndConsumablesMapper zhcm;//耗材mapper


    /**
     * 新开病人费用
     */
    public boolean patientAddPay(PatientPayObjVo payObjVo){
        //===================新增费用记录
        ZyDoctorEnjoinExecuteRecord deer = new ZyDoctorEnjoinExecuteRecord(payObjVo.getPoPrice(),payObjVo.getPoPtNo(),payObjVo.getPoSid(),payObjVo.getPoText());
        deerm.insert(deer);//新增

        //================扣除病人费用
        pbm.updatePatientBasePrice(payObjVo.getPoPrice(),payObjVo.getPoPtNo());//修改病人余额


        return false;
    }


    /**
     * 执行医嘱方法
     */
    public Map<String,String> doctorEnjoinExecute(List<ZyDoctorEnjoinDetails> detailsList, Long sId){
        double price = 0;//药品价格
        Map<String,String> erro = new HashMap<>();//错误提示


        if(!detailsList.isEmpty()){
            //添加执行医嘱记录
            for (ZyDoctorEnjoinDetails list : detailsList) {
//                QueryWrapper pharmacyQw = new QueryWrapper<ZyDrugPharmacy>().eq("drug_id",list.getDesDrugId()).eq("ks_id",staff.getKsId());//根据药品编号查询
//                List<ZyDrugPharmacy> pharmacy = dpms.selectList(pharmacyQw);
//                if(!pharmacy.isEmpty()){
//                    ZyDrugPharmacy zyDrugPharmacy = pharmacy.get(0);
//                        Long count = list.getDesFrequency() == null ? 1 : list.getDesFrequency();
//                        for (int i = 0;i < count;i++){
//                            record.setDerDrugPrice(zyDrugPharmacy.getDpDrugPrice() * list.getDesCount());//执行一次的价格
//                            record.setDesId(list.getDesId());//医嘱详情编号
//                            record.setPtNo(list.getPtNo());//病人住院号
//                            record.setSId(staff.getSId());//护士编号
//                            price += zyDrugPharmacy.getDpDrugPrice() * list.getDesCount();//叠加价格
//                            deerm.insert(record);//新增
//                        }
//                    continue;
//                }

//                ===============变量
                ZyDoctorEnjoinExecuteRecord record = new ZyDoctorEnjoinExecuteRecord();
                Long count = list.getDesFrequency() == null ? 1 : list.getDesFrequency();
                DrugVo drugVo = difm.selectById(list.getDesDrugId());//药品对象
                Staff staff = sm.selectById(sId);//查询员工
                ZyHCindConsumables zyHCindConsumables = zhcm.selectById(list.getDesDrugId());//耗材对象
                Long drugCount = 0L;






                //========================================================执行业务操作逻辑
                for (int i = 0;i < count;i++){
                    drugCount += list.getDesCount();//叠加药品数量
                    record.setDerDrugPrice(list.getDesPrice() * list.getDesCount());//执行一次的价格
                    record.setDesId(list.getDesId());//医嘱详情编号
                    record.setPtNo(list.getPtNo());//病人住院号
                    record.setSId(sId);//护士编号
                    price += list.getDesPrice() * list.getDesCount();//叠加价格
                    deerm.insert(record);//新增
                }

                if(list.getDesDrugIs() == 2){//耗材药品

                    QueryWrapper yfHc = new  QueryWrapper<ZyHCindConsumables>().eq("Consumables_id",list.getDesDrugId());//根据药品编号查询
                    List<ZyHCindConsumables> zyHCindConsumablesList  = zhcm.selectList(yfHc);

                    ZyHCindConsumables zyHCindConsumabless = new ZyHCindConsumables(zyHCindConsumablesList.get(0).getConsumablesId(),zyHCindConsumablesList.get(0).getConsumablesPhy() - drugCount);
                    zhcm.updateById(zyHCindConsumabless);//修改药房库存
                    //===========================新增发药记录
                    YfDispensing yfDispensing = new YfDispensing("住院医嘱(耗材)",sId,staff.getSName(),list.getDesDrugName(),drugCount,list.getDesDrugId(),2L);
                    ydm.insert(yfDispensing);//新增

                }


                if(list.getDesDrugIs() == 1){//将不是处方药的药品直接发药将药房库存扣除  新增发药记录

                    QueryWrapper yfQw = new  QueryWrapper<ZyYfDrugInventoryVo>().eq("drug_id",list.getDesDrugId());//根据药品编号查询
                    List<ZyYfDrugInventoryVo> ZyYfDrugInventoryVoList = ydivm.selectList(yfQw);
                    //!
                    if(ZyYfDrugInventoryVoList.isEmpty()){//如果药房没有改药品就新增该药品信息（一般不会出现这种状况）*
                        ZyYfDrugInventoryVo zydi = new ZyYfDrugInventoryVo(list.getDesDrugId(),list.getDesDrugName(),0 - drugCount,drugVo.getYkSupplierId());
                        ydivm.insert(zydi);//新增
                    }else{
                        ZyYfDrugInventoryVo zyYfDrugInventoryVo = new ZyYfDrugInventoryVo(ZyYfDrugInventoryVoList.get(0).getYfDrvenId(),ZyYfDrugInventoryVoList.get(0).getYfDrvenCount() - drugCount);
                        ydivm.updateById(zyYfDrugInventoryVo);//修改药房库存
                    }
                    //===========================新增发药记录
                    YfDispensing yfDispensing = new YfDispensing("住院医嘱(药品)",sId,staff.getSName(),list.getDesDrugName(),drugCount,list.getDesDrugId(),1L);
                    ydm.insert(yfDispensing);//新增

                }


            }
            //将医嘱详表里面的执行记录修改为当前时间
            dedm.doctorEnjoinDetailsExecuteFor(detailsList);

            //===============扣费
            pbm.updatePatientBasePrice(price,detailsList.get(0).getPtNo());//修改病人余额

            return erro;

        }else{
            return erro;
        }
    }


}
