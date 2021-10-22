package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyBedChangeRecord;
import cn.gson.hisspring.model.pojos.ZyChangeDeptRecord;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import cn.gson.hisspring.model.service.inhospital_module_service.AllRecordService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 病人所有的记录查询
 */
@RestController
@CrossOrigin
public class AllRecordController {
    @Autowired
    AllRecordService ars;

    @RequestMapping("seltzychangeksrecord")
    public List<ZyChangeDeptRecord> seltZyChangeKsRecord(@RequestBody String str){
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        return ars.seltZyChangeKsRecord(selectExecuteVo);
    }

    @RequestMapping("seltZyChangeBedRecord")
    public List<ZyBedChangeRecord> seltZyChangeBedRecord(@RequestBody String str){
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        return ars.seltZyChangeBedRecord(selectExecuteVo);
    }


}
