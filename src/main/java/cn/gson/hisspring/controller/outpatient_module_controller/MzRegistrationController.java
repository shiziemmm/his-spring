package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.MzRegistration;
import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.pojos.pojos_vo.GuaHaoVO;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalCardService;
import cn.gson.hisspring.model.service.outpatient_module_service.MzRegistrationService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 */

@CrossOrigin
@RestController
public class MzRegistrationController {
    @Autowired
    MzRegistrationService registrationService; /*挂号记录表*/

    @Autowired
    MzMedicalCardService cardService; /*诊疗卡service*/

    @Autowired
    SchedulingMapper schedulingMapper; //七日排班mapper
    @RequestMapping("week-sch")
    public List<Scheduling> cs(@RequestBody GuaHaoVO guaHaoVO) throws ParseException {
//        Map map = JSON.parseObject(str,Map.class);
//        String dates = map.get("dates").toString();
//        Long ksId = Long.parseLong(map.get("ksId").toString());
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
//        Date date1 = df.parse(dates);
//        Calendar c = Calendar.getInstance();
//        c.setTime(date1);
//        c.add(Calendar.DAY_OF_MONTH, 1);
//        Date date2 = c.getTime();
//        String date3 = df.format(date2);
//        System.err.println("增加一天后日期:"+date3);

//        String nows = df.format(new Date());
//        System.err.println("前端"+dates);
//        System.err.println("科室"+ksId);
//        System.err.println("后端"+nows);// new Date()为获取当前系统时间

        String dateVue =null;
        if(guaHaoVO.getDateVue() !=null){
            dateVue= df.format(guaHaoVO.getDateVue());
        }
        String dateJav = df.format(guaHaoVO.getDateJav());

        System.err.println("前端"+guaHaoVO.getDateVue());
        System.err.println("科室"+guaHaoVO.getKsId());
        System.err.println("条件"+guaHaoVO.getText());
        System.err.println("后端"+guaHaoVO.getDateJav());// new Date()为获取当前系统时间
        System.err.println(guaHaoVO.getIndex());
        System.err.println(dateVue);
        System.err.println(dateJav);
        if(guaHaoVO.getIndex() == 0){
            return schedulingMapper.selectNowWeek(dateVue,dateJav ,guaHaoVO.getKsId(),guaHaoVO.getText());
        }else{
            String date3 = null;
            if(dateVue!=null){
                Date date1 = df.parse(dateVue);
                Calendar c = Calendar.getInstance();
                c.setTime(date1);
                c.add(Calendar.DAY_OF_MONTH, 1);
                Date date2 = c.getTime();
                date3 = df.format(date2);
                System.err.println("增加一天后日期:"+date3);

            }
            return schedulingMapper.selectNowWeek(date3,dateJav ,guaHaoVO.getKsId(),guaHaoVO.getText());
        }


    }

    //查询单个诊疗卡
    @GetMapping("byIdCard")
    public MzMedicalCard selectById(String mcCard){
        MzMedicalCard mzMedicalCard = cardService.selectById(mcCard.replace(" ", ""));
        return mzMedicalCard;
    }
    //新增挂号表
    @PostMapping("addReg")
    public String addReg(@RequestBody String regArr){
        MzRegistration mzRegistration = JSON.parseObject(regArr, MzRegistration.class);
        try {
            registrationService.addReg(mzRegistration);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //查询挂号记录表
    @GetMapping("selectReg")
    public List<MzRegistration> selectReg(String reg,Integer index ,String dates){
        System.err.println(reg);
        System.err.println(index);
        System.err.println(dates);
        String regs = null;
        if(reg!=null){
            regs = reg.replace(" ", "");
        }
        return registrationService.selectMzRegistration(regs,index,dates);
    }
}
