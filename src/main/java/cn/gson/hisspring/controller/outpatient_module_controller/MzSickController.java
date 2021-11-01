package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.MzSick;
import cn.gson.hisspring.model.service.outpatient_module_service.MzSickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 门诊-病人资料-Controller
 */

@CrossOrigin
@RestController
public class MzSickController {
    @Autowired
    MzSickService mzSickService;

    @PostMapping("/addMzSick")//添加病人信息
    public String addMzSick(@RequestBody MzSick mzSick) {
        try {
            mzSickService.addMzSick(mzSick);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
