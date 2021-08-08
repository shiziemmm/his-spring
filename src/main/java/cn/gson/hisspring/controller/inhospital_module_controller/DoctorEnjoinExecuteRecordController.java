package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinExecuteRecord;
import cn.gson.hisspring.model.service.inhospital_module_service.DoctorEnjoinExecuteRecordService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class DoctorEnjoinExecuteRecordController {

    @Autowired
    DoctorEnjoinExecuteRecordService deers;//执行医嘱service


    @RequestMapping("addDoctorEnjoinExecute")
    public boolean doctorEnjoinExecute(@RequestBody String str){
        System.err.println(str);
        Map map = JSON.parseObject(str, Map.class);
        List<ZyDoctorEnjoinDetails> zyDoctorEnjoinExecuteRecordList  = JSON.parseArray(map.get("doctorEnjoinList").toString(),ZyDoctorEnjoinDetails.class);
        zyDoctorEnjoinExecuteRecordList.forEach(c->{
            System.out.println(c);
        });
        Long sId = Long.parseLong(map.get("sId").toString());
        System.out.println(zyDoctorEnjoinExecuteRecordList);

        deers.doctorEnjoinExecute(zyDoctorEnjoinExecuteRecordList,sId);


        return false;
    }
}
