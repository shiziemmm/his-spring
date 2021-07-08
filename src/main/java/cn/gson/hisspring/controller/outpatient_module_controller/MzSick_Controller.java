package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzSick;
import cn.gson.hisspring.model.service.outpatient_module_service.MzSick_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * 门诊-病人资料-Controller
 */

@CrossOrigin
@RestController
public class MzSick_Controller {
    @Autowired
    MzSick_Service mzSickService;

    @PostMapping("/addMzSick")
    public String addMzSick(@RequestBody MzSick mzSick){
        try {
            mzSickService.addMzSick(mzSick);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }


}
