package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.ZyInhospitalApply;
import cn.gson.hisspring.model.pojos.pojos_vo.InHospitalMzVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import cn.gson.hisspring.model.service.inhospital_module_service.InHospitalApplyService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 住院申请controller层
 */

@RestController
@CrossOrigin
public class InHospitalController {

    @Autowired
    InHospitalApplyService has;


    /**
     * 查询所有未审核的住院申请信息
     */
    @RequestMapping("selectNoHspApply")
    public List<ZyInhospitalApply> selectHspApplyByInIs(@RequestBody String str) {
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        System.err.println(selectExecuteVo);
        return has.selectHspApplyByInIs(selectExecuteVo);
    }

    /**
     * 查询出所有主治医生
     *
     * @return
     */
    @RequestMapping("select-patient-staffAll")
    public List<Staff> selectPatientStaffAll() {
        return has.selectPatientStaffAll();
    }

    @RequestMapping("updateHspInIs")
    public boolean HspApplyByInIdUpdateInIs(Long inId) {

        return has.HspApplyByInIdUpdateInIs(inId);
    }

    /**
     * 新增住院申请
     */
    @RequestMapping("add-inHospital-mzSick")
    public boolean addHospital(@RequestBody String str) {
        InHospitalMzVo inHospitalMzVo = JSON.parseObject(str, InHospitalMzVo.class);
        System.err.println(inHospitalMzVo);
        return has.addHospital(inHospitalMzVo);
    }


}
