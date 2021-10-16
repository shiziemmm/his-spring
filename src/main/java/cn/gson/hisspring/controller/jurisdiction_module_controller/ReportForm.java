package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.pojos.pojos_vo.WeekVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@CrossOrigin
@RestController
@Slf4j
public class ReportForm {
    private static final int FIRST_DAY = Calendar.MONDAY;
    @RequestMapping("post")
    private void reportfrom(){
        List<ReportForm> list=new ArrayList<>();
        //获取当前时间
        Calendar calendar = Calendar.getInstance();
        //        调用方法回到本周的第一天
        setToFirstDay(calendar);
        System.err.println(calendar);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");//注意月份是MM
        for (int i = 0; i < 7; i++) {
            cn.gson.hisspring.model.pojos.pojos_vo.ReportForm rf=new cn.gson.hisspring.model.pojos.pojos_vo.ReportForm();

            rf = printDay(calendar,rf);
            //           循环给日期加天数
            calendar.add(Calendar.DATE, 1);
            System.err.println(rf);
        }

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
    private static cn.gson.hisspring.model.pojos.pojos_vo.ReportForm printDay(Calendar calendar, cn.gson.hisspring.model.pojos.pojos_vo.ReportForm reportForm) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
//        SimpleDateFormat dateFormat2 = new SimpleDateFormat("EE");
        reportForm.setXq(dateFormat.format(calendar.getTime()));
//        weekVo.setRq(dateFormat.format(calendar.getTime()));
        return reportForm;
    }
}
