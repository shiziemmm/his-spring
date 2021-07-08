package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentMapper;
import cn.gson.hisspring.model.pojos.Department;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin//跨域
@Controller
@ResponseBody
public class DepartmentKsController {
    @Autowired
    DepartmentKsMapper dm;
    @Autowired
    DepartmentMapper dept;

    @RequestMapping("ks-list")
    public List<DepartmentKs> dome(){
//        List<DepartmentKs> ks = dm.selectList(null);
//        ks.forEach(System.out::println);
        List<DepartmentKs> selectlist = dm.selectlist();
        return selectlist;
    }
    @RequestMapping("bm-list")

    public List<Department> dept(){
        List<Department> bm = dept.selectList(null);
        return bm;
    }
}
