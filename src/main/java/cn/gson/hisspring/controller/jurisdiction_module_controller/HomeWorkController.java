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
    SchedulingService schedulingMapper;
    @RequestMapping("home-sch")
    public List<Scheduling> homeSch(){
        System.out.println("开始时间"+getBeginDayOfWeek()+"======"+getDayEndTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//注意月份是MM
        String star= sdf.format(getBeginDayOfWeek());
        String end=sdf.format(getDayEndTime());
        System.out.println(star+"==="+end);
//        Scheduling d= new Scheduling();
//        d.setScDate(star);
//        d.setScEnd(end);
//        System.out.println(d);
        List<Scheduling> schedulings = schedulingMapper.selectAll(star,end);
        return schedulings;
    }





//    public static Date getDayStartTime(Date d) {
//        d=new Date();
//              Calendar calendar = Calendar.getInstance();
//               if(null != d) calendar.setTime(d);
//               calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
//                       calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
//            calendar.set(Calendar.MILLISECOND, 0);
//           return new Timestamp(calendar.da);
//     }
    //获取本周的开始时间
      public static Date getBeginDayOfWeek() {
               Date date = new Date();
               if (date == null) {
                      return null;
               }
         Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayofweek = cal.get(Calendar.DAY_OF_WEEK);
        if (dayofweek == 1) {
           dayofweek += 7;
         }
          cal.add(Calendar.DATE, 2 - dayofweek);
       return cal.getTime();
          }
    public static Date getDayEndTime() {
        Date date = new Date();
        if (date == null) {
            return null;
        }
                 Calendar calendar = Calendar.getInstance();
             if(null != date) calendar.setTime(date);
                calendar.set(calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
                 calendar.set(Calendar.MILLISECOND, 999);
                return calendar.getTime();
    }
}
