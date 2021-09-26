package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinExecuteRecord;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientCostVo;
import cn.gson.hisspring.model.service.inhospital_module_service.PatientCostSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class PatientCostController {
    @Autowired
    PatientCostSerivce pcs;//病人明细service


    /**
     * 根据病人编号查询所有的消费记录
     * @param ptNo
     * @return
     */
    @RequestMapping("select-by-ptNo")
    public List<PatientCostVo> selectCostByPtNo(Long ptNo,String text){
        System.err.println(text);
       return pcs.selectCostByPtNo(ptNo,text);
    }


    /**
     * 查询所有不同费用的名称
     */
    @RequestMapping("select-costName")
    public List<ZyDoctorEnjoinExecuteRecord> selectCostName(){
        return pcs.selectCostName();
    }
}
