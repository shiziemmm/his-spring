package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import cn.gson.hisspring.model.service.inhospital_module_service.DoctorEnjoinDetailsService;
import cn.gson.hisspring.model.service.inhospital_module_service.DoctorEnjoinService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 医嘱详情controller
 */
@RestController
@CrossOrigin
public class DoctorEnjoinDetailsController {
    @Autowired
    DoctorEnjoinDetailsService deds;//医嘱详情service


    @RequestMapping("select-doctorEnjoinDetails-ByPtNo")
    public List<ZyDoctorEnjoinDetails> doctorEnjoinDetailsSelectByPtId(@RequestBody String str){
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        System.err.println(selectExecuteVo);
        return deds.doctorEnjoinDetailsSelectByPtId(selectExecuteVo);
    }

    @RequestMapping("selectDoctorEnjoinDetailsByPtNo")
    public List<ZyDoctorEnjoinDetails> patientDoctorByPtNo(Long ptNo){
        return deds.patientDoctorByPtNo(ptNo);
    }
}
