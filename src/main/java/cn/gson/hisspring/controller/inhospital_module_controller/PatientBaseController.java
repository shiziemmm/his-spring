package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientCheckoutVo;
import cn.gson.hisspring.model.pojos.pojos_vo.ResultManVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
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
     * 根据科室编号查询今天排班
     */
    @RequestMapping("home-sch-byksId")
    public List<Scheduling> selectDateByKsId(Long ksId) {
        return pbs.selectDateByKsId(ksId);
    }

    /**
     * 取消已开项目方法
     */
    @RequestMapping("cancel-chekout")
    public boolean cancelPatientCheckout(@RequestBody String str) {

        System.err.println(str);
        Map map = JSON.parseObject(str, Map.class);
        TjManResult tjManResult = JSON.parseObject(map.get("tjManResult").toString(), TjManResult.class);
        Long ptNo = JSON.parseObject(map.get("ptNo").toString(), Long.class);
        Long sId = JSON.parseObject(map.get("sId").toString(), Long.class);
        if (sId == null) {
            return false;
        }
        if (ptNo == null) {
            return false;
        }
        if (tjManResult == null) {
            return false;
        }

        pbs.cancelPatientCheckout(tjManResult, ptNo, sId);
        return false;
    }

    /**
     * 根据科室编号查询科室对象
     */
    @RequestMapping("select-ks-obj")
    public DepartmentKs selectKsObj(Long ksId) {
        System.err.println(ksId);
        return pbs.selectKsObj(ksId);
    }

    /**
     * 根据住院号查询已开检验项目的医生
     */
    @RequestMapping("select-result-ByManId-Staff")
    public List<Staff> selectResultByManIdStaff(Long ptNo) {
        return pbs.selectResultByManIdStaff(ptNo);
    }

    /**
     * 根据住院号查询该病人已开的项目
     *
     * @return
     */
    @RequestMapping("select-manResult-byPtNo")
    public List<ResultManVo> selectManResultByPtNo(@RequestBody String str) {
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);//查询条件
        return pbs.selectTjResultByPtNo(selectExecuteVo);
    }

    /**
     * 新增病人化验项目
     *
     * @param
     * @return
     */
    @RequestMapping("add-patient-checkout")
    public boolean addPatientCheckout(@RequestBody String str) {
        PatientCheckoutVo patientCheckoutVo = JSON.parseObject(str, PatientCheckoutVo.class);
        System.err.println(str);
        pbs.addPatientCheckout(patientCheckoutVo);
        return false;
    }


    @RequestMapping("patient-changeDept")
    public boolean patientChangeDept(@RequestBody String str) {
        System.out.println(str);
        ZyChangeDeptRecord deptRecord = JSON.parseObject(str, ZyChangeDeptRecord.class);
        return pbs.patientChangeDept(deptRecord);
    }

    /**
     * 查询没有病床信息以及没有出院的病人登记信息
     *
     * @return
     */
    @RequestMapping("selectPBNoBed")
    public List<ZyPatientBase> selectPatientBaseNoBed() {
        return pbs.selectPatientNoBed("1", new SelectExecuteVo());
    }


    /**
     * 修改病床数据和住院登记数据以及新增病床使用记录表
     *
     * @param str 前端传过来的值
     * @return
     */
    @RequestMapping("patientAndBedUpdate")
    public boolean updatePatientAndBedUpdate(@RequestBody String str) {

        Map map = JSON.parseObject(str, Map.class);

        Long bdId = map.get("bdId").equals("") ? null : Long.parseLong(map.get("bdId").toString());

        Long ptNo = map.get("ptNo").equals("") ? null : Long.parseLong(map.get("ptNo").toString());

        Double price = map.get("price").equals("") ? null : Double.parseDouble(map.get("price").toString());

        if (bdId == null || ptNo == null || price == null) {
            return false;
        }
        return pbs.PatientUpdateBdIdAndBedUpdateBdIsAndPtNo(bdId, ptNo, price);
    }

    /**
     * 查询所有未出院的病人住院信息
     *
     * @return
     */
    @RequestMapping("patientAlls")
    public List<ZyPatientBase> selectPatientNoOutCY(@RequestBody String str) {
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        System.err.println(selectExecuteVo);
        return pbs.selectPatientNoOutCY(selectExecuteVo);
    }

    /**
     * 查询所有未出院的病人住院信息
     *
     * @return
     */
    @RequestMapping("patientAll")
    public List<ZyPatientBase> selectPatientAll(@RequestBody String str) {
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        System.err.println(selectExecuteVo);
        return pbs.selectPatientNoBed("", selectExecuteVo);
    }


    /**
     * 新增住院登记信息
     *
     * @return
     */
    @RequestMapping("addPatient")
    public boolean insertPatient(@RequestBody String str) {
        System.out.println(str);
        ZyPatientBase patientBase = JSON.parseObject(str, ZyPatientBase.class);
        return pbs.insertPatient(patientBase);
    }


    @RequestMapping("select-patient-sId")
    public List<ZyPatientBase> selectPatientBySId(Long sId, Long ksId, String text, Long is) {
        System.err.println(sId);
        System.out.println(ksId);
        System.err.println("搜索" + text);
        System.out.println("iss" + is);
        return pbs.selectPatientBySId(sId, ksId, text, is);
    }


    /**
     * 查询住院病人信息以及病人缴费详细
     */
    @RequestMapping("PatientAndPay")
    public List<ZyPatientBase> selectPatientAndPay(@RequestBody String str) {
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        System.err.println(selectExecuteVo);
        return pbs.selectPatientAndPay(selectExecuteVo);
    }


}
