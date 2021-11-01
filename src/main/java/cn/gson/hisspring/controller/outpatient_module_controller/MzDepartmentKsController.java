package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.DepartmentKs;
import cn.gson.hisspring.model.service.outpatient_module_service.MzDepartmentKsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 权限科室表--Controller（门诊部分）
 */
@CrossOrigin
@RestController
public class MzDepartmentKsController {
    @Autowired
    MzDepartmentKsService departmentKsService;

    @GetMapping("allAepartmentKs")
    public List<DepartmentKs> allDepartmentKs() {
        return departmentKsService.selectDepartmentKs();
    }

}
