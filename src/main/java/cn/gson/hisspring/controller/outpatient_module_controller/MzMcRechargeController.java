package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzMcRecharge;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMcRechargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *  门诊充值记录表-controller
 */

@CrossOrigin
@RestController
public class MzMcRechargeController {

    @Autowired
    MzMcRechargeService mcRechargeService;

    @GetMapping("allMzMcRecharge")
    public List<MzMcRecharge> allMzMcRecharge(String like){
        return mcRechargeService.allLikeMzMcRecharge(like);
    }
}
