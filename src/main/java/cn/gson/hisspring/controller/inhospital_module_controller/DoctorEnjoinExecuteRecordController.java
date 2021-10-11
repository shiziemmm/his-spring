package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinExecuteRecord;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientPayObjVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
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


    /**
     * 多条件查询已执行医嘱
     */
    @RequestMapping("doctor-where-execute")
    public List<ZyDoctorEnjoinExecuteRecord> selectExecuteDoctor(@RequestBody String str){
        System.err.println(str);
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        System.out.println(selectExecuteVo);
        return deers.selectExecuteDoctor(selectExecuteVo);
    }



    /**
     * 执行医嘱方法
     * @param str 医嘱集合  员工编号
     * @return
     */
    @RequestMapping("addDoctorEnjoinExecute")
    public Map<String, String> doctorEnjoinExecute(@RequestBody String str){
        Map map = JSON.parseObject(str, Map.class);
        List<ZyDoctorEnjoinDetails> zyDoctorEnjoinExecuteRecordList  = JSON.parseArray(map.get("doctorEnjoinList").toString(),ZyDoctorEnjoinDetails.class);
        zyDoctorEnjoinExecuteRecordList.forEach(c->{
            System.out.println(c);
        });
        Long sId = JSON.parseObject(map.get("sId").toString(),Long.class);

        return deers.doctorEnjoinExecute(zyDoctorEnjoinExecuteRecordList,sId);
    }


    /**
     * 新开病人费用方法
     */
    @RequestMapping("addPatientPay")
    public boolean patientAddPay(@RequestBody PatientPayObjVo patientPayObjVo){
        System.err.println(patientPayObjVo);
        if(patientPayObjVo.getPoPtNo() == null && patientPayObjVo.getPoSid() == null){
            return false;
        }
        deers.patientAddPay(patientPayObjVo);
        return false;
    }
}
