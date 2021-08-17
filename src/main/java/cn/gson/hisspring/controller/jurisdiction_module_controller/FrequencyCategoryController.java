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
    public Object cs(long ksId){
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
            List<Scheduling> panBan = sl.selectWeek(paiBan2.getRq(),ksId);
            paiBan2.setSlist(panBan);
            //将查询出来的结果赋值给需要返回出去的集合
            ban2List.add(paiBan2);
            //System.out.println(rq);
//           循环给日期加天数
            calendar.add(Calendar.DATE, 1);
        }
       return ban2List;
    }
    private static void setToFirstDay(Calendar calendar) {
//        获取本周的第一天
        while (calendar.get(Calendar.DAY_OF_WEEK) !=FIRST_DAY) {
            calendar.add(Calendar.DATE, -1);
        }
    }
    private static WeekVo printDay(Calendar calendar,WeekVo weekVo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("EE");
        weekVo.setXq(dateFormat2.format(calendar.getTime()));
        weekVo.setRq(dateFormat.format(calendar.getTime()));
        return weekVo;
    }

}
