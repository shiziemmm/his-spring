package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 门诊诊疗卡-Controller
 */

@CrossOrigin
@RestController
public class MzMedicalCardController {
    @Autowired
    MzMedicalCardService medicalCardService;

    @PostMapping("inserMedicalCard")
    public Long inserMedicalCard(){
        Long aLong = medicalCardService.inserCard();
        return aLong;
    }

    @PostMapping("descCard")
    public MzMedicalCard descCard(Integer index, Integer pageSize){
        return (MzMedicalCard) medicalCardService.selectCardCreateTime(index,pageSize);
    }

}
