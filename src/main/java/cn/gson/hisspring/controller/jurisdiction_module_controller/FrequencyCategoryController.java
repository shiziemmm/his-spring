package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.pojos.Frequency;
import cn.gson.hisspring.model.pojos.FrequencyCategory;
import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.pojos.pojos_vo.SchedulingVo;
import cn.gson.hisspring.model.pojos.pojos_vo.WeekVo;
import cn.gson.hisspring.model.service.jurisdiction_module_service.FrequencyCategoryService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.FrequencyService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.SchedulingService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.SchedulingVoService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class FrequencyCategoryController {
    private static Date star=new Date();//记录一个天数
    @Autowired
    FrequencyCategoryService fre;
    @Autowired
    FrequencyService fs;
    @Autowired
    SchedulingMapper sl;
    @Autowired
    SchedulingVoService sv;
    @Autowired
    SchedulingService sls;
    private static final int FIRST_DAY = Calendar.MONDAY;

    @RequestMapping("list-fre")
    public List<FrequencyCategory> dome(){
        return fre.dome();
    }

    /**
     * 查询班次信息
     * @param bcId
     * @return
     */
    @RequestMapping("bc-list")
    public List<Frequency> dome1(long bcId){
        List<Frequency> frequencies = fs.selectAllId(bcId);
        return frequencies;
    }
    /**
     * 根据职称查询人员排班信息
     */
    @RequestMapping("add-sch")
    public List<SchedulingVo> list(){
        List<SchedulingVo> list = sv.list();
        return list;

    }

    /**
     * 新增排班记录
     * @param grant
     */
    @RequestMapping("saveGrant")
    private void saveGrant(@RequestParam("grant") String grant) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");//注意月份是MM
        JSONObject o = JSONObject.parseObject(grant);
        String rq=o.get("rq").toString();
        Integer bcId = Integer.parseInt(o.get("bcId").toString());
        List<Integer> funs = JSONArray.parseArray(o.get("funs").toString(),Integer.TYPE);
        Date date = simpleDateFormat.parse(rq);
        System.out.println(date);
        System.out.println(bcId);
        System.out.println(funs);
        sls.addSch(date,bcId,funs);
    }
    /*
    获取当前星期
     */
    @RequestMapping("week")
    public Object cs(long ksId) throws ParseException {
        Date date=cs();
        List<WeekVo> ban2List=new ArrayList<>();
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        //        调用方法回到本周的第一天
        setToFirstDay(calendar);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");//注意月份是MM
        for (int i = 0; i < 7; i++) {
            WeekVo paiBan2=new WeekVo();
//           将星期，日期，赋值
            paiBan2 = printDay(calendar,paiBan2);
            //查询这个科室的排班信息，并赋值
            List<Scheduling> panBan = sl.selectWeek(paiBan2.getRq(),ksId);
            paiBan2.setSlist(panBan);
            //将查询出来的结果赋值给需要返回出去的集合
            ban2List.add(paiBan2);
            //判断按钮可否使用
            Date days = simpleDateFormat.parse(paiBan2.getRq());
            if(days.getTime()<=date.getTime()){
                paiBan2.setState(true);
            }else{
                paiBan2.setState(false);
            }
//           循环给日期加天数
            calendar.add(Calendar.DATE, 1);
        }
       return ban2List;
    }

    /**
     * 上一周数据
     * @return
     */
    @RequestMapping("star-week")
    public Object star() throws ParseException {
        Date date=cs();
        List<WeekVo> ban2List=new ArrayList<>();
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        //        调用方法回到本周的第一天
        setToWeek(calendar);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");//注意月份是MM
        for (int i = 0; i < 7; i++) {
            WeekVo paiBan2=new WeekVo();
//           将星期，日期，赋值
            paiBan2 = printDay(calendar,paiBan2);
            //查询这个科室的排班信息，并赋值
            List<Scheduling> panBan = sl.selectAllWeek(paiBan2.getRq());
            paiBan2.setSlist(panBan);
            //将查询出来的结果赋值给需要返回出去的集合
            ban2List.add(paiBan2);
            //判断按钮可否使用
            Date days = simpleDateFormat.parse(paiBan2.getRq());
            if(days.getTime()<=date.getTime()){
                paiBan2.setState(true);
            }else{
                paiBan2.setState(false);
            }
//           循环给日期加天数
            calendar.add(Calendar.DATE, 1);
        }
        System.out.println(ban2List);
        return ban2List;
    }
    /**
     * 下一周数据
     * @return
     */
    @RequestMapping("end-week")
    public Object end() throws ParseException {
        Date date=cs();
        List<WeekVo> ban2List=new ArrayList<>();
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        //        调用方法回到本周的第一天
        setEndWeek(calendar);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");//注意月份是MM
        for (int i = 0; i < 7; i++) {
            WeekVo paiBan2=new WeekVo();
//           将星期，日期，赋值
            paiBan2 = printDay(calendar,paiBan2);
            //查询这个科室的排班信息，并赋值
            List<Scheduling> panBan = sl.selectAllWeek(paiBan2.getRq());
            paiBan2.setSlist(panBan);
            //将查询出来的结果赋值给需要返回出去的集合
            ban2List.add(paiBan2);
            //判断按钮可否使用
            Date days = simpleDateFormat.parse(paiBan2.getRq());
            if(days.getTime()<=date.getTime()){
                paiBan2.setState(true);
            }else{
                paiBan2.setState(false);
            }
//           循环给日期加天数
            calendar.add(Calendar.DATE, 1);
        }
        System.out.println(ban2List);
        return ban2List;
    }

    /**
     * 返回本周
     * @return
     */
    @RequestMapping("this-week")
    public Object thisWeek(){
        List<WeekVo> ban2List=new ArrayList<>();
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        //        调用方法回到本周的第一天
        setToFirstDay(calendar);
        for (int i = 0; i < 7; i++) {
            WeekVo paiBan2=new WeekVo();
//           将星期，日期，赋值
            paiBan2 = printDay(calendar,paiBan2);
            //查询这个科室的排班信息，并赋值
            List<Scheduling> panBan = sl.selectAllWeek(paiBan2.getRq());
            paiBan2.setSlist(panBan);
            //将查询出来的结果赋值给需要返回出去的集合
            ban2List.add(paiBan2);
            //System.out.println(rq);
//           循环给日期加天数
            calendar.add(Calendar.DATE, 1);
        }
        System.out.println(ban2List);
        return ban2List;
    }
    @RequestMapping("dome")
    public void lake() throws ParseException {
        Date date=cs();
        System.out.println(date.getTime());
    }
    /**
     *   获取本周的第一天
     * @param calendar
     */
    private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) !=FIRST_DAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }

    /**
     * 获取上一周日期
     * @param calendar
     */
    private static void setToWeek(Calendar calendar){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.setTime(star);
        calendar.add(Calendar.DATE, - 7);
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        calendar.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        System.out.println("所在周星期一的日期：" + format.format(calendar.getTime()));
        star=calendar.getTime();
        System.out.println(star);
//        Date d = calendar.getTime();
//        String day = format.format(d);
//        System.out.println("过去七天："+day);

    }
    private static void setEndWeek(Calendar calendar){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        calendar.setTime(star);
        calendar.add(Calendar.DATE, + 7);
        int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        if (1 == dayWeek) {
            calendar.add(Calendar.DAY_OF_MONTH, -1);
        }
        calendar.setFirstDayOfWeek(Calendar.MONDAY);// 设置一个星期的第一天，按中国的习惯一个星期的第一天是星期一
        int day = calendar.get(Calendar.DAY_OF_WEEK);// 获得当前日期是一个星期的第几天
        calendar.add(Calendar.DATE, calendar.getFirstDayOfWeek() - day);// 根据日历的规则，给当前日期减去星期几与一个星期第一天的差值
        System.out.println("所在周星期一的日期：" + format.format(calendar.getTime()));
        star=calendar.getTime();
        System.out.println(star);
//        Date d = calendar.getTime();
//        String day = format.format(d);
//        System.out.println("过去七天："+day);

    }
    private static WeekVo printDay(Calendar calendar,WeekVo weekVo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("EE");
        weekVo.setXq(dateFormat2.format(calendar.getTime()));
        weekVo.setRq(dateFormat.format(calendar.getTime()));
        return weekVo;
    }
    //获得ture or false
    private static Date cs() throws ParseException {
        //获得当前时间的时间戳
        SimpleDateFormat TimeNow = new SimpleDateFormat("yyyy/MMdd");
        Date date = TimeNow.parse(TimeNow.format(Calendar.getInstance().getTime()));
       return date;
    }

}
