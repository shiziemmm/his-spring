package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.pojos.pojos_vo.WeekVo;
import cn.gson.hisspring.model.service.jurisdiction_module_service.SchedulingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
@Slf4j
@CrossOrigin
@RestController
public class HomeWorkController {
    static  List list=new ArrayList();
    @Autowired
    SchedulingMapper schedulingMapper;
    //今日排班
    @RequestMapping("home-sch")
    public List<Scheduling> homeSch(){
        List<Scheduling> schedulings = schedulingMapper.selectDate();
        return schedulings;
    }
//    @RequestMapping("week-sch")
//    public List<Scheduling>  cs(){
//        List<Scheduling> list = schedulingMapper.selectNowWeek();
//        return list;
//    }

}

