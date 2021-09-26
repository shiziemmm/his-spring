package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.DepartmentKs;
import cn.gson.hisspring.model.pojos.MzCaseHistory;
import cn.gson.hisspring.model.pojos.ZyInhospitalApply;
import cn.gson.hisspring.model.service.outpatient_module_service.MzOpcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 门诊问诊 controller
 */
@CrossOrigin
@RestController
public class MzOpcController {
    @Autowired
    MzOpcService opcService;

    /**
     * 添加住院申请
     * @param inhospitalApply
     */
    @RequestMapping("addInHospita")
    public String addInHospitalApply(@RequestBody ZyInhospitalApply inhospitalApply){
        try {
            System.err.println(inhospitalApply);
            opcService.addInHospitalApply(inhospitalApply);
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
