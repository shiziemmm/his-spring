package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoin;
import cn.gson.hisspring.model.service.inhospital_module_service.DoctorEnjoinService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 医嘱controller层
 */
@RestController
@CrossOrigin
public class DoctorEnjoinController {

    @Autowired
    DoctorEnjoinService des;//医嘱service

    @RequestMapping("add-doctorEnjoin")
    public boolean addDoctorEnjoin(@RequestBody String str){
        System.err.println(str);
        ZyDoctorEnjoin zyDoctorEnjoin = JSON.parseObject(str, ZyDoctorEnjoin.class);
        return des.addDoctorEnjoin(zyDoctorEnjoin);
    }


    /**
     * 根据住院号查询医嘱信息
     * @return
     */
    @RequestMapping("select-doctorEnjoin-ByPtNo")
    public List<ZyDoctorEnjoin> doctorEnjoinSelectByPtId(Long ptNo){
        System.err.println("住院号"+ptNo);
       return des.doctorEnjoinSelectByPtId(ptNo);
    }

}
