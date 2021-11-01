package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyStopDoctorEnjoin;
import cn.gson.hisspring.model.service.inhospital_module_service.StopDoctorEnjoinService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 停嘱controller
 */
@RestController
@CrossOrigin
public class StopDoctorEnjoinController {

    @Autowired
    StopDoctorEnjoinService sdes;//停用医嘱service

    @RequestMapping("stop-doctor-enjoin")
    public boolean stopDoctorEnjoinOrDoctorEnjoinDetails(@RequestBody String str) {
        System.err.println(str);
        ZyStopDoctorEnjoin zyStopDoctorEnjoin = JSON.parseObject(str, ZyStopDoctorEnjoin.class);
        System.out.println(str);
        return sdes.stopDoctorEnjoinOrDoctorEnjoinDetails(zyStopDoctorEnjoin);
    }

}
