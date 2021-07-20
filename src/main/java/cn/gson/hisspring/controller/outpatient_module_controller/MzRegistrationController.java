package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.MzRegistration;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalCardService;
import cn.gson.hisspring.model.service.outpatient_module_service.MzRegistrationService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 */

@CrossOrigin
@RestController
public class MzRegistrationController {
    @Autowired
    MzRegistrationService registrationService;

    @Autowired
    MzMedicalCardService cardService;
    //查询单个卡
    @GetMapping("byIdCard")
    public MzMedicalCard selectById(String mcCard){
        MzMedicalCard mzMedicalCard = cardService.selectById(mcCard);
        return mzMedicalCard;
    }
    //新增挂号表
    @PostMapping("addReg")
    public String addReg(@RequestBody String regArr){
        MzRegistration mzRegistration = JSON.parseObject(regArr, MzRegistration.class);
        System.err.println(mzRegistration);
        try {
            registrationService.addReg(mzRegistration);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //查询挂号记录表
    @GetMapping("selectReg")
    public List<MzRegistration> selectReg(String like){
         return registrationService.selectMzRegistration(like);
    }

}
