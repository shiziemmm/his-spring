package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.service.jurisdiction_module_service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class StaffController {

    @Autowired
    StaffService ss;


    /**
     * 根据科室编号查询
     * @param ksId 科室编号
     * @return
     */
    @RequestMapping("select-staff-all")
    public List<Staff> selectStaffAll(Integer ksId){
        return ss.selectStaffAll(ksId);
    }
}
