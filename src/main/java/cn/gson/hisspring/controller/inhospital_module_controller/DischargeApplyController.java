package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDischarge;
import cn.gson.hisspring.model.pojos.ZyDischargeApply;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import cn.gson.hisspring.model.service.inhospital_module_service.DischargeApplyService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 病人申请出院controller
 */
@RestController
@RequestMapping("/dis")
@CrossOrigin
public class DischargeApplyController {
    @Autowired
    DischargeApplyService das;

    /**
     * 根据住院号查询费用信息
     */
    @RequestMapping("cost-discharge-ptno")
    public Double costDischargeAllByPtNo(Long ptNo, String text) {
        System.out.println(ptNo + "===========" + text);
        return das.costDischargeAllByPtNo(ptNo, text);
    }

    /**
     * 新增出院申请
     *
     * @param str
     * @return
     */
    @RequestMapping("addDischarge")
    public String insertDischargeApply(@RequestBody String str) {
        System.out.println(str);
        ZyDischargeApply apply = JSON.parseObject(str, ZyDischargeApply.class);
        System.out.println(apply);
        return das.addDischargeApply(apply);
    }


    @RequestMapping("updata-patient-apply")
    public boolean callPatientApply(@RequestBody String str) {
        System.out.println(str);
        Map map = JSON.parseObject(str, Map.class);
        return das.callPatientApply(Long.parseLong(map.get("ptNo").toString()), map.get("dgaNoCause").toString());
    }


    /**
     * 查询出院申请的病人信息
     *
     * @param search
     * @return
     */
    @RequestMapping("select-discharge-all")
    public List<ZyDischargeApply> selectDischargeAll(String search) {
        return das.selectDischargeApplyAll(search);
    }

    /**
     * 根据住院号将病人出院
     */
    @RequestMapping("add-discharge-byptNo")
    public boolean addDischargeByPtNo(@RequestBody String str) {
        ZyDischarge zyDischarge = JSON.parseObject(str, ZyDischarge.class);
        System.err.println(zyDischarge);
        return das.addDischargeByPtNo(zyDischarge);
    }

    /**
     * 查询出所有已经出院的病人信息
     */
    @RequestMapping("select-discharge-all-where")
    public List<ZyDischarge> selectDischargeAllWhere(@RequestBody String str) {
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);

        return das.selectDischargeAll(selectExecuteVo);
    }

}
