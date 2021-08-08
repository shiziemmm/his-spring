package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import cn.gson.hisspring.model.service.inhospital_module_service.DoctorEnjoinDetailsService;
import cn.gson.hisspring.model.service.inhospital_module_service.DoctorEnjoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
    public List<ZyDoctorEnjoinDetails> doctorEnjoinDetailsSelectByPtId(Long ptNo){
        return deds.doctorEnjoinDetailsSelectByPtId(ptNo);
    }

    @RequestMapping("selectDoctorEnjoinDetailsByPtNo")
    public List<ZyDoctorEnjoinDetails> patientDoctorByPtNo(Long ptNo){
        return deds.patientDoctorByPtNo(ptNo);
    }
}
