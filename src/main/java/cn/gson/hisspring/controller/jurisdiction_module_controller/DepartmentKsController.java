package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
public class DepartmentKsController {
    @Autowired
    DepartmentKsMapper dm;

    @RequestMapping("dome")
    @CrossOrigin
    public List<DepartmentKs> dome(){
        List<DepartmentKs> ks = dm.selectList(null);
        ks.forEach(System.out::println);
        return ks;
    }
}
