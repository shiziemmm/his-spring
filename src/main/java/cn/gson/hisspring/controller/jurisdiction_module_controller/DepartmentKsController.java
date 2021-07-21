package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentMapper;
import cn.gson.hisspring.model.pojos.Department;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import cn.gson.hisspring.model.service.jurisdiction_module_service.DepartmentKsService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.DepartmentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;
@CrossOrigin//跨域
@Controller
@ResponseBody
/*
科室

 */
public class DepartmentKsController {
    @Autowired
    DepartmentKsService dm;


    /**
     * 查询住院部的科室名称
     */
    @RequestMapping("zy-ks-list")
   public List<DepartmentKs> DepartmentKsMapper(){
       return dm.selectZyKs();
   }


    //查询所有科室
    @RequestMapping("ks-list")
    public List<DepartmentKs> dome(){
        List<DepartmentKs> selectlist = dm.selectlist();
        return selectlist;
    }
    //查询没有部门科室
    //查询有部门的科室
    @RequestMapping("bmks-list")
    public List<DepartmentKs> select(Long id){
        System.out.println("部门id"+id);

        List<DepartmentKs> dome = dm.selectId(id);
        return dome;



    }
    @RequestMapping("ksname-list")
    public List<DepartmentKs> dome1(){
        List<DepartmentKs> list=dm.selectName();
        return list;
    }
    @PostMapping("add-ks")
    public int addlist(@RequestBody DepartmentKs departmentKs){
        int addlist = dm.addlist(departmentKs);
        if(addlist>0){
            return 1;
        }else{
            return 0;
        }
    }

    @PostMapping("upa-ks")
    public int upalist(@RequestBody DepartmentKs departmentKs){
        int upalist = dm.upalist(departmentKs);
        if(upalist>0){
            return 1;
        }else{
            return 0;
        }
    }
}
