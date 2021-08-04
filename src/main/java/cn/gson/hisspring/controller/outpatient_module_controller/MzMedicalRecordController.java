package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzMedicalRecord;
import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalRecordService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 就诊记录表
 */
@CrossOrigin
@RestController
public class MzMedicalRecordController {
    @Autowired
    MzMedicalRecordService recordService;
    //添加所有的就诊信息
    @RequestMapping("addRecord")
    public String addRecord(@RequestBody RecordVo recordVo){
//        System.err.println(JSONObject.toJSONString(recordVo.getMedicalRecordObject()));
        System.err.println(recordVo.getMedicalRecordObject());
        try {
            recordService.addRecipe(recordVo);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping("selectAllRecord")
    public List<MzMedicalRecord> selectMedicalRecord( Long indexRecord){
        System.err.println(indexRecord);
        return recordService.selectMedicalRecord(indexRecord);
    }
}
