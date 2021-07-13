package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.MzSick;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalCardService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    @GetMapping("pawdReset")//重置密码
    public String pawdReset(String mcNumber){
        try {
            medicalCardService.pawdReset(mcNumber,null);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @PostMapping("updatePawd")//修改密码
    public String updatePawd(@RequestBody String str){
        Map map = JSON.parseObject(str, Map.class);
        try {
            medicalCardService.pawdReset(map.get("mcNumber").toString(),map.get("pawd1").toString());
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @PostMapping("descCard") //分页排序----暂时没用到
    public MzMedicalCard descCard(Integer index, Integer pageSize){
        return (MzMedicalCard) medicalCardService.selectCardCreateTime(index,pageSize);
    }

    @GetMapping("allDescCard") //排序所有病人信息
    public List<MzMedicalCard> descCard(String mzSickTest){
        System.out.println(mzSickTest);
        return medicalCardService.selectAllCards(mzSickTest);
    }
}
