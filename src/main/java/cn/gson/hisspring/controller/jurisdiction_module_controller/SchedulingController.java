package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.service.jurisdiction_module_service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class SchedulingController {
    @Autowired
    SchedulingService service;

    @RequestMapping("paiban")
    public List<Scheduling> select(){
        return service.selectList();
    }


}
