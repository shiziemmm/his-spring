package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyDeptDrugAllot;
import cn.gson.hisspring.model.service.inhospital_module_service.DeptDrugAllotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 科室库粗调拨controller
 */
@RestController
@CrossOrigin
public class DeptDrugAllotController {

    @Autowired
    DeptDrugAllotService ddas;//科室库存调拨service

    /**
     * 根据科室编号查询调拨记录
     * @param ksId
     * @return
     */
    @RequestMapping(value = "select-by-ksId")
    public List<ZyDeptDrugAllot> selectByKsId(Long ksId){
        return ddas.selectByKsId(ksId);
    }

    /**
     * 循环新增科室库存调拨记录
     * @param str
     * @return
     */
    public boolean addDeptDrugAllotList(@RequestBody String str){

        return false;
//        return ddas.addDeptDrugAllotFor()
    }

}
