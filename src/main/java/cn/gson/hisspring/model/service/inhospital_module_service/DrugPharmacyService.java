package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DrugPharmacyMapper;
import cn.gson.hisspring.model.pojos.ZyDrugPharmacy;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 科室药品库存service
 */
@Service
@Transactional
public class DrugPharmacyService {

    @Autowired
    DrugPharmacyMapper dpm;//科室药品库存mapper

    /**
     * 根据科室编号查询科室药品库存
     * @param ksId
     * @return
     */
    public List<ZyDrugPharmacy> selectDrugPharmacyAll(Long ksId){
        QueryWrapper<ZyDrugPharmacy> qw = new QueryWrapper();
        qw.eq("ks_id",ksId);
        return dpm.selectList(qw);
    }

    /**
     * 根据科室库存编号修改库存警戒线
     */
    public boolean updateDrugPharmacyByDpId(Long dpId,Integer dpGuard){
        ZyDrugPharmacy zyDrugPharmacy = new ZyDrugPharmacy(dpId,dpGuard);

        //修改库存警戒线
        int i = dpm.updateById(zyDrugPharmacy);
        if(i > 0)
            return true;
        return false;
    }
}
