package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinDetailsMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinExecuteRecordMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DrugPharmacyMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.pojos.*;
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
    DrugPharmacyMapper dpms;//科室药品库存mapper

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
                //===============
                ZyDoctorEnjoinExecuteRecord record = new ZyDoctorEnjoinExecuteRecord();
                Long count = list.getDesFrequency() == null ? 1 : list.getDesFrequency();

                Long drugCount = 0L;
                for (int i = 0;i < count;i++){
                    drugCount += list.getDesCount();//叠加药品数量
                    record.setDerDrugPrice(list.getDesPrice() * list.getDesCount());//执行一次的价格
                    record.setDesId(list.getDesId());//医嘱详情编号
                    record.setPtNo(list.getPtNo());//病人住院号
                    record.setSId(sId);//护士编号
                    price += list.getDesPrice() * list.getDesCount();//叠加价格
                    deerm.insert(record);//新增
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
