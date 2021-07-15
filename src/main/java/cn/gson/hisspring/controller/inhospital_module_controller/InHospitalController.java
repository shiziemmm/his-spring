package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyInhospitalApply;
import cn.gson.hisspring.model.service.inhospital_module_service.InHospitalApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 住院申请controller层
 */

@RestController
@CrossOrigin
public class InHospitalController {

    @Autowired
    InHospitalApplyService has;


    /**
     * 查询所有未审核的住院申请信息
     */
    @RequestMapping("selectNoHspApply")
    public List<ZyInhospitalApply> selectHspApplyByInIs(){
        return has.selectHspApplyByInIs();
    }


    @RequestMapping("updateHspInIs")
    public boolean HspApplyByInIdUpdateInIs(Long inId){

        return has.HspApplyByInIdUpdateInIs(inId);
    }


}
