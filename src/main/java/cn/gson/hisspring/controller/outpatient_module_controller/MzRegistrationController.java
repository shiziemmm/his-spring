package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzRegistration;
import cn.gson.hisspring.model.service.outpatient_module_service.MzRegistrationService;
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

    @PostMapping("addReg")
    public String addReg(@RequestBody MzRegistration regArr){
        System.err.println(regArr);
        try {
            registrationService.addReg(regArr);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @GetMapping("selectReg")
    public List<MzRegistration> selectReg(String like){
         return registrationService.selectMzRegistration(like);
    }

}
