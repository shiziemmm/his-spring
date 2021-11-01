package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.*;
import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.SupplierMapper;
import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YfDispensingMapper;
import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.DispensingVo;
import cn.gson.hisspring.model.pojos.pojos_vo.DrugVo;
import cn.gson.hisspring.model.pojos.pojos_vo.PharmacyVo;
import cn.gson.hisspring.model.pojos.pojos_vo.ZyYfDrugInventoryVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 科室药品库存service
 */
@Service
@Transactional
public class DrugPharmacyService {

    @Autowired
    DrugPharmacyMapper dpm;//科室药品库存mapper

    @Autowired
    ZyDrugInFormationMapper difm;//药品mapper

    @Autowired
    YfDispensingMapper ydm;//发药记录mapper

    @Autowired
    DrugPharmacyDispensingRecordMapper dpdrm;//住院医嘱使用记录Mapper

    @Autowired
    DoctorEnjoinExecuteRecordMapper deerm;//已执行医嘱mapper

    @Autowired
    YfDrugInventoryVoMapper ydivm;//药房mapper


    /**
     * 根据科室编号查询科室药品库存
     *
     * @param ksId
     * @return
     */
    public List<ZyDrugPharmacy> selectDrugPharmacyAll(Long ksId) {
        return dpm.selectList(null);
    }

    /**
     * 查询每天需要扣除的医嘱药品（处方药）
     *
     * @param ksId
     * @return
     */
    public List<PharmacyVo> selectPharmacyByKsOrAll(Long ksId) {
        return dpm.selectPharmacyByKsOrAll(ksId);
    }

    /**
     * 根据科室编号和药品编号或者药品编号发药
     *
     * @param dispensingVo
     * @return
     */
    public boolean dispensingByKsOrDrug(DispensingVo dispensingVo) {
        // =============根据条件查询需要发药的数据
        System.out.println(dispensingVo);
        List<PharmacyVo> pharmacyVoList = dpm.selectPharmacyByKsIdOrDrugId(dispensingVo);
        //=======================================将已执行医嘱修改状态
        List<ZyDoctorEnjoinExecuteRecord> zyDoctorEnjoinExecuteRecordList = deerm.selectExecutePharmacyByKsIdOrDrugId(dispensingVo);
        deerm.updateDoctorExecuteIs(zyDoctorEnjoinExecuteRecordList);//循环修改

        //=============循环需要扣除药品库存
        for (PharmacyVo pv : pharmacyVoList) {
            //使用变量
            QueryWrapper qw = new QueryWrapper<ZyDrugPharmacy>().eq("drug_id", pv.getDesDrugId());
            DrugVo drugVo = difm.selectById(pv.getDesDrugId());//根据药品编号查询药品信息
            Long drugCount = (pv.getKc() / drugVo.getDrugQuantity()) + 1;//发药数量
            Long phCount = (drugVo.getDrugQuantity() * drugCount) - pv.getKc();//扣除需要发的数量之后的库存

            ZyDrugPharmacy pharmacy = null;
            List<ZyDrugPharmacy> zyDrugPharmaciesList = dpm.selectList(qw);


            //===============================================================================扣除药房库存
            //===根据药品编号查询药房库存
            QueryWrapper yfQw = new QueryWrapper<ZyYfDrugInventoryVo>().eq("drug_id", drugVo.getDrugId()).orderBy(false, false, "yf_Drven_mftdate");//根据药品编号查询
            List<ZyYfDrugInventoryVo> ZyYfDrugInventoryVoList = ydivm.selectList(yfQw);
            //!
            if (ZyYfDrugInventoryVoList.isEmpty()) {//如果药房没有改药品就新增该药品信息（一般不会出现这种状况）*
                ZyYfDrugInventoryVo zydi = new ZyYfDrugInventoryVo(drugVo.getDrugId(), drugVo.getDrugName(), 0, drugVo.getYkSupplierId());
                ydivm.insert(zydi);//新增
            }


            ZyYfDrugInventoryVo zyYfDrugInventoryVo = new ZyYfDrugInventoryVo(ZyYfDrugInventoryVoList.get(0).getYfDrvenId(), ZyYfDrugInventoryVoList.get(0).getYfDrvenCount() - drugCount);
            ydivm.updateById(zyYfDrugInventoryVo);//修改药房库存

            //=====================新增住院医嘱处方药使用记录
            ZyDrugPharmacyDispensingRecord zyDrugPharmacyDispensingRecord = new ZyDrugPharmacyDispensingRecord("医嘱处方药", dispensingVo.getDvSid(), pv.getKsId(), pv.getDesDrugId(), pv.getKc(), drugVo.getDrugUnit());
            dpdrm.insert(zyDrugPharmacyDispensingRecord);//新增


            if (zyDrugPharmaciesList.isEmpty() || zyDrugPharmaciesList.get(0).getDpInventory() < pv.getKc()) {//如果是进这里就说明这个药品需要去拆盒

                for (ZyYfDrugInventoryVo yfObj : ZyYfDrugInventoryVoList) {//循环药房药品进行不同批次的发药
                    if (drugCount < yfObj.getYfDrvenCount() && yfObj.getYfDrvenCount() != 0) {//当需要发药的数量小于当前药品批次数量就直接发药结束循环
                        YfDispensing yfDispensing = new YfDispensing("住院医嘱(药品)", dispensingVo.getDvSid(), dispensingVo.getDvName(), drugVo.getDrugName(), drugCount, drugVo.getDrugId(), 1L, yfObj.getYfDrvenBatch());
                        ydm.insert(yfDispensing);//新增
                        break;
                    } else {
                        drugCount = drugCount - yfObj.getYfDrvenCount();//减去当前批次数量
                        //===========================新增发药记录
                        YfDispensing yfDispensing = new YfDispensing("住院医嘱(药品)", dispensingVo.getDvSid(), dispensingVo.getDvName(), drugVo.getDrugName(), drugCount, drugVo.getDrugId(), 1L, yfObj.getYfDrvenBatch());
                        ydm.insert(yfDispensing);//新增
                    }
                }

                //=========================新增或者修改拆盒药品库存
                if (!zyDrugPharmaciesList.isEmpty()) {//如果查到此药品已存在拆盒药品里面就修改
                    pharmacy = new ZyDrugPharmacy(zyDrugPharmaciesList.get(0).getDpId(), phCount + zyDrugPharmaciesList.get(0).getDpInventory());
                    dpm.updateById(pharmacy);//修改
                } else {
                    pharmacy = new ZyDrugPharmacy(drugVo.getSpecSpecification(), drugVo.getDrugQuantity(), phCount, drugVo.getDrugId(), drugVo.getDrugParticle(), drugVo.getDrugUnit(), drugVo.getDrugName());
                    dpm.insert(pharmacy);//新增
                }
            } else if (zyDrugPharmaciesList.get(0).getDpInventory() >= pv.getKc()) {//如果进这里就说明有可以减去该药品的库存

                //=========================修改拆盒药品库存
                if (!zyDrugPharmaciesList.isEmpty()) {//如果查到此药品已存在拆盒药品里面就修改
                    pharmacy = new ZyDrugPharmacy(zyDrugPharmaciesList.get(0).getDpId(), zyDrugPharmaciesList.get(0).getDpInventory() - pv.getKc());
                    dpm.updateById(pharmacy);//修改
                }
            }
        }
        return true;
    }

    /**
     * 循环扣除药房库存
     */

//    /**
//     * 根据科室库存编号修改库存警戒线
//     */
//    public boolean updateDrugPharmacyByDpId(Long dpId,Integer dpGuard){
//        ZyDrugPharmacy zyDrugPharmacy = new ZyDrugPharmacy(dpId,dpGuard);
//
//        //修改库存警戒线
//        int i = dpm.updateById(zyDrugPharmacy);
//        if(i > 0)
//            return true;
//        return false;
//    }
}
