package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDischarge;
import cn.gson.hisspring.model.pojos.ZyDischargeApply;
import cn.gson.hisspring.model.service.inhospital_module_service.DischargeApplyService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 病人申请出院controller
 */
@RestController
@CrossOrigin
public class DischargeApplyController {
    @Autowired
    DischargeApplyService das;

    /**
     * 新增住院申请
     * @param str
     * @return
     */
    @RequestMapping("addDischarge")
    public String insertDischargeApply(@RequestBody String str){
        System.out.println(str);
        ZyDischargeApply apply = JSON.parseObject(str, ZyDischargeApply.class);
        System.out.println(apply);
        return das.addDischargeApply(apply);
    }


    @RequestMapping("updata-patient-apply")
    public boolean callPatientApply(@RequestBody String str){
        System.out.println(str);
        Map map = JSON.parseObject(str, Map.class);
        return das.callPatientApply(Long.parseLong(map.get("ptNo").toString()),map.get("dgaNoCause").toString());
    }

}
