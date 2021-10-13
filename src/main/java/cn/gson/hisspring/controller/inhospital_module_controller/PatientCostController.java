package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinExecuteRecord;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientCostVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import cn.gson.hisspring.model.service.inhospital_module_service.PatientCostSerivce;
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
public class PatientCostController {
    @Autowired
    PatientCostSerivce pcs;//病人明细service


    /**
     * 根据病人编号查询所有的消费记录
     * @return
     */
    @RequestMapping("select-by-ptNo")
    public List<PatientCostVo> selectCostByPtNo(@RequestBody String str){
        System.err.println(str);
        Map map = JSON.parseObject(str, Map.class);

        Long ptNo = JSON.parseObject(map.get("ptNo").toString(),Long.class);//住院编号
        String text = (String) map.get("text");//类型
        SelectExecuteVo executeVo = JSON.parseObject(map.get("payWhere").toString(),SelectExecuteVo.class);//条件
        System.err.println(executeVo);
       return pcs.selectCostByPtNo(ptNo,text,executeVo);
    }



    /**
     * 查询所有不同费用的名称
     */
    @RequestMapping("select-costName")
    public List<ZyDoctorEnjoinExecuteRecord> selectCostName(){
        return pcs.selectCostName();
    }
}
