package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalRecordService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 就诊记录表
 */
@CrossOrigin
@RestController
public class MzMedicalRecordController {
    @Autowired
    MzMedicalRecordService recordService;

    @RequestMapping("addRecord")
    public String addRecord(@RequestBody RecordVo recordVo){
//        System.err.println(JSONObject.toJSONString(recordVo.getMedicalRecordObject()));
//        System.err.println(JSONObject.toJSONString(recordVo.getRecipeObject()));
        System.err.println(recordVo.getMedicalRecordObject());
        System.err.println(recordVo.getMedicalRecordObject().getsId());
        System.err.println(recordVo.getRecipeObject());

        try {
            recordService.addRecipe(recordVo);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
