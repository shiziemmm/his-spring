package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.StaffMapper;
import cn.gson.hisspring.model.pojos.Frequency;
import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.service.jurisdiction_module_service.FrequencyService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.SchedulingService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin
@RestController
public class SchedulingController {
    @Autowired
    SchedulingService service;
    @Autowired
    StaffMapper staffMapper;
    @Autowired
    FrequencyService frequencyService;
    @Autowired
    SchedulingService schedulingService;
    @Autowired
    SchedulingMapper schedulingMapper;
  //验证排班
    @RequestMapping("addSch")
    public Object addSch(String grants){
        JSONObject o = JSONObject.parseObject(grants);
        Integer bcId = Integer.parseInt(o.get("bcId").toString());
        String rq=(o.get("rq").toString());
        List<Integer> funs = JSONArray.parseArray(o.get("funs").toString(),Integer.TYPE);
        List<Scheduling> schedulings = schedulingMapper.seletSch(rq,funs);
        System.err.println(schedulings.size());
        if(schedulings.size()==0){
            return "ok";
        }else{
            return "false";
        }
    }
      //根据科室显示员工
    @GetMapping("staff-ks")
    public  List<Staff> selectksId(long id){
        return staffMapper.selectksId(id);
    }



























}
