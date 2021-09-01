package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDrugPharmacy;
import cn.gson.hisspring.model.service.inhospital_module_service.DrugPharmacyService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class DrugPharmacyController {

    @Autowired
    DrugPharmacyService dps;//科室药库service

    /**
     * 根据科室编号查询当前科室所有药品库存
     */
    @RequestMapping("select-drug-pharmacyByKsId")
    public List<ZyDrugPharmacy> selectDrugPharmacyAll(Long ksId){
        return dps.selectDrugPharmacyAll(ksId);
    }


    @RequestMapping("update-byDpId-dpGuard")
    public boolean updateByDpId(@RequestBody String str){
        System.err.println(str);
        Map map = JSON.parseObject(str, Map.class);
        try{
            Long dpId = Long.parseLong(map.get("bpId").toString());
            Integer dpGuard = Integer.parseInt(map.get("dpGuard").toString());
            return dps.updateDrugPharmacyByDpId(dpId, dpGuard);
        }catch (Exception e){
            return false;
        }
    }
}
