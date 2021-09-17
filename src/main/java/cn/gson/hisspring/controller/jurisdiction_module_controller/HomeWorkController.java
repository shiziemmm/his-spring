package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.service.jurisdiction_module_service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class HomeWorkController {
    @Autowired
    SchedulingMapper schedulingMapper;
    @RequestMapping("home-sch")
    public List<Scheduling> homeSch(){
        List<Scheduling> schedulings = schedulingMapper.selectDate();
        return schedulings;
    }
}
