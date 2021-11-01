package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzOpcNumber;
import cn.gson.hisspring.model.service.outpatient_module_service.MzOpcNumberService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 排号表 Controller
 */
@CrossOrigin
@RestController
public class MzOpcNumberController {
    @Autowired
    MzOpcNumberService countService;

    //排号表查询
    @RequestMapping("allMzOpcNumber")
    public List<MzOpcNumber> allMzOpcNumber(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String ksName = map.get("ksName").toString();
        String science = map.get("science").toString();
        System.err.println("门诊排号" + ksName);
        System.err.println(science);
        List<MzOpcNumber> mzOpcNumbers = countService.selectMzOpcNumber(Long.parseLong(ksName), Long.parseLong(science));
        return mzOpcNumbers;
    }

    //过号
    @RequestMapping("jumpMark")
    public String jumpMark(@RequestBody MzOpcNumber opcNumber) {
        try {
            countService.jumpMark(opcNumber);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    //接诊就修改挂号表的状态
    @RequestMapping("upRtNumber")
    public void upRtNumber(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String rtNumber = map.get("rtNumber").toString();
        countService.upRtNumber(rtNumber);
    }

}
