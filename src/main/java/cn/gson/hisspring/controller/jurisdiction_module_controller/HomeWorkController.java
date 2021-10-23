package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.echatrsMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalRecordMapper;
import cn.gson.hisspring.model.pojos.MzMedicalRecord;
import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.pojos.pojos_vo.WeekVo;
import cn.gson.hisspring.model.pojos.pojos_vo.echartsVo;
import cn.gson.hisspring.model.service.jurisdiction_module_service.SchedulingService;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@CrossOrigin
@RestController
public class HomeWorkController {
    static  List list=new ArrayList();
    @Autowired
    SchedulingMapper schedulingMapper;
    @Autowired
    echatrsMapper echatrsMapper;
    @Autowired
    MzMedicalRecordMapper mzMedicalRecordMapper;
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
    @RequestMapping("echarts")
    public String getAllEcharts(){
        List<echartsVo> echarts = echatrsMapper.getAllEcharts();
        List<echartsVo> echartss = echatrsMapper.getList();
        System.err.println(echarts);
        HashMap<Object, Object> res = new HashMap<>();
        List<Double> name = new ArrayList<>();
        List<Double> num = new ArrayList<>();
        String dome=JSON.toJSONString(res);
        if(echarts.size()!=0){
            num.add(Double.parseDouble(echarts.get(0).getC1()));
            num.add(Double.parseDouble(echarts.get(0).getC2()));
            num.add(Double.parseDouble(echarts.get(0).getC3()));
            num.add(Double.parseDouble(echarts.get(0).getC4()));
            num.add(Double.parseDouble(echarts.get(0).getC5()));
            num.add(Double.parseDouble(echarts.get(0).getC6()));
            num.add(Double.parseDouble(echarts.get(0).getC7()));
            num.add(Double.parseDouble(echarts.get(0).getC8()));
            num.add(Double.parseDouble(echarts.get(0).getC9()));
            num.add(Double.parseDouble(echarts.get(0).getC10()));
            num.add(Double.parseDouble(echarts.get(0).getC11()));
            num.add(Double.parseDouble(echarts.get(0).getC12()));
        }
        if(echartss.size()!=0){
            name.add(Double.parseDouble(echartss.get(0).getC1()));
            name.add(Double.parseDouble(echartss.get(0).getC2()));
            name.add(Double.parseDouble(echartss.get(0).getC3()));
            name.add(Double.parseDouble(echartss.get(0).getC4()));
            name.add(Double.parseDouble(echartss.get(0).getC5()));
            name.add(Double.parseDouble(echartss.get(0).getC6()));
            name.add(Double.parseDouble(echartss.get(0).getC7()));
            name.add(Double.parseDouble(echartss.get(0).getC8()));
            name.add(Double.parseDouble(echartss.get(0).getC9()));
            name.add(Double.parseDouble(echartss.get(0).getC10()));
            name.add(Double.parseDouble(echartss.get(0).getC11()));
            name.add(Double.parseDouble(echartss.get(0).getC12()));
        }



        res.put("name",name);
        res.put("num",num);
        System.err.println(res);
        String res_string = JSON.toJSONString(res);
        System.err.println(res_string);
        return res_string;

    }
    @RequestMapping("chaxunnums")
    public int nums(){
        List<MzMedicalRecord> list=mzMedicalRecordMapper.chaxunnums();
        return list.size();
    }
    @RequestMapping("moneny")
    public double moneny(){
        List<echartsVo> list= echatrsMapper.zhuyu();
        List<echartsVo> map= echatrsMapper.menzhen();
        System.err.println(list+"1");
        System.err.println(map+"2");
        double nums=0.00;
        double  mapnums=0.00;
        if(!list.isEmpty()){
            for (int i = 0; i < list.size(); i++) {
                    nums=list.get(i).getPcdPrice()+0;
                }
        }
        if(!map.isEmpty()){
                for (int j = 0; j < map.size(); j++) {
                    mapnums=0+map.get(j).getPcdPrice();
                }
        }
        double moeny=nums+mapnums;
        BigDecimal b   =   new   BigDecimal(moeny);
        double   f1   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
        }



    }



