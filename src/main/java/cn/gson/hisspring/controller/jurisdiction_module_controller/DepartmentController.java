package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.Department;
import cn.gson.hisspring.model.service.jurisdiction_module_service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
/*
    部门
 */
public class DepartmentController {
    @Autowired
    DepartmentService dept;


    @RequestMapping("bm-list")
    public List<Department> dept(){
        List<Department> bm = dept.selectList();
        return bm;
    }
    @PostMapping("add-list")
    public String addlist(@RequestBody Department de){
        int i=dept.add(de);
        if(i>0){
            return "ok";
        }else{
            return "fasle";
        }
    }
    @PostMapping("upa-list")
    public String upalist(@RequestBody Department de){
        int i=dept.upa(de);
        if(i>0){
            return "ok";
        }else{
            return "false";
        }
    }
    @PostMapping("delet-list")
    public String deletlist(@RequestBody Department de){
        int i=dept.dete(de.getDeId());
        if(i>0){
            return "ok";
        }else{
            return "false";
        }
    }
    @RequestMapping("selectlike")
    public List<Department> selectlike(@RequestBody Department d){
        List<Department> selectlike = dept.selectlike(d);
        return selectlike;

    }
}
