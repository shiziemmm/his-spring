package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.pojos.pojos_vo.WeekVo;
import cn.gson.hisspring.model.service.jurisdiction_module_service.SchedulingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
public class HomeController {
    @Autowired
    SchedulingService sl;
    private static final int FIRST_DAY = Calendar.MONDAY;

    @RequestMapping("now-date")
    public Object newDate(long ksId,long sId) {
        List<WeekVo> ban2List = new ArrayList<>();
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        //        调用方法回到本周的第一天
        setToFirstDay(calendar);
        for (int i = 0; i < 7; i++) {
            WeekVo paiBan2 = new WeekVo();
//           将星期，日期，赋值
            paiBan2 = printDay(calendar, paiBan2);
            //查询这个科室的排班信息，并赋值
            List<Scheduling> panBan = sl.selectNow(paiBan2.getRq(),ksId,sId);
            paiBan2.setSlist(panBan);
            //将查询出来的结果赋值给需要返回出去的集合
            ban2List.add(paiBan2);
            //循环给日期加天数
            calendar.add(Calendar.DATE, 1);
        }
        return ban2List;
    }

    private static WeekVo printDay(Calendar calendar, WeekVo weekVo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("EE");
        weekVo.setXq(dateFormat2.format(calendar.getTime()));
        weekVo.setRq(dateFormat.format(calendar.getTime()));
        return weekVo;
    }

    /**
     * 获取本周的第一天
     *
     * @param calendar
     */
    private static void setToFirstDay(Calendar calendar) {
        while (calendar.get(Calendar.DAY_OF_WEEK) != FIRST_DAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }
}
