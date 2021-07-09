package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 门诊诊疗卡-Controller
 */

@CrossOrigin
@RestController
public class MzMedicalCardController {
    @Autowired
    MzMedicalCardService medicalCardService;

    @PostMapping("inserMedicalCard") //生成诊疗卡
    public Long inserMedicalCard(){
        Long aLong = medicalCardService.inserCard();
        return aLong;
    }

    @PostMapping("descCard") //分页排序
    public MzMedicalCard descCard(Integer index, Integer pageSize){
        return (MzMedicalCard) medicalCardService.selectCardCreateTime(index,pageSize);
    }

    @GetMapping("allDescCard") //排序所有病人信息
    public List<MzMedicalCard> descCard(){
        return medicalCardService.selectAllCards();
    }
}
