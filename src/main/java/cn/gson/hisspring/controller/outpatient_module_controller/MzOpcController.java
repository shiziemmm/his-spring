package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.DepartmentKs;
import cn.gson.hisspring.model.pojos.MzCaseHistory;
import cn.gson.hisspring.model.pojos.MzPayment;
import cn.gson.hisspring.model.pojos.ZyInhospitalApply;
import cn.gson.hisspring.model.service.outpatient_module_service.MzOpcService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 门诊问诊 controller
 */
@CrossOrigin
@RestController
public class MzOpcController {
    @Autowired
    MzOpcService opcService;


    @RequestMapping("addInHospita")
    public String addInHospitalApply(@RequestBody String str){
        try {
            Map map = JSON.parseObject(str, Map.class);
            String rtNumber = map.get("rtNumber").toString();
            ZyInhospitalApply inhospitalApply = JSON.parseObject(map.get("inhospitalApply").toString(),ZyInhospitalApply.class);
            System.err.println(inhospitalApply+"====\n"+rtNumber);
            opcService.addInHospitalApply(inhospitalApply ,rtNumber);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * 查询所有科室信息
     * @return
     */
    @RequestMapping("selectKs")
    public List<DepartmentKs> selectKs(Integer index){
        System.err.println(index);
        return opcService.selectKs(index);
    }

    /**
     * 查询所有的病例信息
     */
    @RequestMapping("selectBl")
    public List<MzCaseHistory> selectBl(Integer index){
        System.err.println(index+"ssssssssssssssssssssss");
        return opcService.selectCaseHistory(index);
    }

}
