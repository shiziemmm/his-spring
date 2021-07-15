package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyPatientBase;
import cn.gson.hisspring.model.service.inhospital_module_service.PatientBaseService;
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
public class PatientBaseController {

    @Autowired
    PatientBaseService pbs;


    /**
     * 查询没有病床信息以及没有出院的病人登记信息
     * @return
     */
    @RequestMapping("selectPBNoBed")
    public List<ZyPatientBase> selectPatientBaseNoBed(){
        return pbs.selectPatientNoBed("1");
    }


    /**
     *修改病床数据和住院登记数据以及新增病床使用记录表
     * @param str 前端传过来的值
     * @return
     */
    @RequestMapping("patientAndBedUpdate")
    public boolean updatePatientAndBedUpdate(@RequestBody String str){

        Map map = JSON.parseObject(str, Map.class);

        Long bdId =map.get("bdId").equals("") ? null : Long.parseLong(map.get("bdId").toString());

        Long ptNo = map.get("ptNo").equals("") ? null : Long.parseLong(map.get("ptNo").toString());

        Double price = map.get("price").equals("") ? null : Double.parseDouble(map.get("price").toString());

        if(bdId == null || ptNo == null || price == null){
            return false;
        }
       return pbs.PatientUpdateBdIdAndBedUpdateBdIsAndPtNo(bdId,ptNo,price);
    }


    /**
     * 查询所有未出院的病人住院信息
     * @return
     */
    @RequestMapping("patientAll")
    public List<ZyPatientBase> selectPatientAll(){
        return pbs.selectPatientNoBed("");
    }


    /**
     * 新增住院登记信息
     * @return
     */
    @RequestMapping("addPatient")
    public boolean insertPatient(@RequestBody String str){
        System.out.println(str);
        ZyPatientBase patientBase = JSON.parseObject(str, ZyPatientBase.class);
        return pbs.insertPatient(patientBase);
    }


    /**
     * 查询住院病人信息以及病人缴费详细
     */
    @RequestMapping("PatientAndPay")
    public List<ZyPatientBase> selectPatientAndPay(){
        return pbs.selectPatientAndPay();
    }

}
