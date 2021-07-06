package cn.gson.hisspring.controller.leijianwei;

import cn.gson.hisspring.model.mapper.ljw.Department;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class demo {
    @Autowired
    Department d;

    @RequestMapping("cs")
    public List<DepartmentKs> dome(){
        List<DepartmentKs> departmentKs = d.selectList(null);
        return departmentKs;

    }
}
