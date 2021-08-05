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
    /**
     * 获取排班信息
     * @param grant
     * @throws ParseException
     */
    @RequestMapping("data-time")
    public void saceGrant(@RequestBody String grant) throws ParseException {
        System.err.println(grant);
        Map map = JSON.parseObject(grant, Map.class);
        List<String> funs = (List<String>) map.get("funs");

        Integer freId=Integer.parseInt(map.get("freid").toString());//班次id
        List<Frequency> list= frequencyService.selectById(freId);//查询班次
        Scheduling d=new Scheduling();
        d.setFcId(Long.parseLong(map.get("freid").toString()));
        d.setScDate(funs.get(0));
        d.setScEnd(funs.get(1));
        d.setScStartDate(list.get(0).getFStartTime());
        d.setScEndDate(list.get(0).getFEndTime());
        System.out.println(d);
        List<Integer> staffIdList = (List<Integer>) map.get("funss");
        schedulingService.addSch(d,staffIdList);
        /**
         * 获取开始结束日期
         */
//        Scheduling funs = JSON.parseObject(o.get("funs").toString(),Scheduling.class);//获取前台传来的日期
//        System.err.println(funs);
        /**
         * 获取员工编号
         */
//        List<Integer> funss=JSONArray.parseArray(o.get("funss").toString(),Integer.TYPE);//获取前台传来的员工编号
//
//        Integer freId=Integer.parseInt(o.get("freid").toString());//班次id
//        List<Frequency> list= frequencyService.selectById(freId);//查询班次
//
//        Scheduling d=new Scheduling();
//        d.setFcId(freId);
//        d.setScDate(funs.get(0));
//        d.setScEnd(funs.get(1));
//        d.setScStartDate(list.get(0).getFStartTime());
//        d.setScEndDate(list.get(0).getFEndTime());
//        System.out.println(d);
//        schedulingService.addSch(d,)


    }
    //根据科室显示员工
    @GetMapping("staff-ks")
    public  List<Staff> selectksId(long id){
        return staffMapper.selectksId(id);
    }

























    //将string转换成date类型
    public static Date time(String times) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        Date date = simpleDateFormat.parse(times);
//        System.out.println(date);   //Mon Sep 02 00:00:00 CST 2019
//        System.out.println(simpleDateFormat.format(date));  //2019-09-02
        return date;
    }
    //获取两个时间之间的日期
    public static List<String> getBetweenDate(String startTime, String endTime){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        // 声明保存日期集合
        List<String> list = new ArrayList<String>();
        try {
            // 转化成日期类型
            Date startDate = sdf.parse(startTime);
            Date endDate = sdf.parse(endTime);

            //用Calendar 进行日期比较判断
            Calendar calendar = Calendar.getInstance();
            while (startDate.getTime()<=endDate.getTime()){
                // 把日期添加到集合
                list.add(sdf.format(startDate));
                // 设置日期
                calendar.setTime(startDate);
                //把日期增加一天
                calendar.add(Calendar.DATE, 1);
                // 获取增加后的日期
                startDate=calendar.getTime();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return list;
    }


}
