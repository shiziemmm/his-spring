package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.YfDruginformation;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlan;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlanDetails;
import cn.gson.hisspring.model.service.pharmacy_module_service.YkDrugpurchasePlanService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class YkDrugpurchasePlanController {
    @Autowired
    YkDrugpurchasePlanService planService;
    /*查询所有的采购计划*/
    @RequestMapping("all-plan")
    public List<YkDrugpurchasePlan> allplan(){
        System.out.println("-----------------查询了----------------------------");
       return planService.allplan();
    }
    /*查询员工   采购计划经手人*/
    @RequestMapping("all-stall")
    public List<Staff> allstall(){
        System.out.println("kkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk");
        return planService.staff();
    }
    /*查询采购计划详单*/
    @RequestMapping("all-ydpd")
    public List<YkDrugpurchasePlanDetails> allydpd(){
        System.out.println("我进来了jjjjjjjjjjjjjjjjjj");
        return planService.allydpd();
    }
    /*查询药品信息*/
    @RequestMapping("drug")
    public List<YfDruginformation> durg(){
        System.out.println("--------------------------查询了药品信息---------------------------");
        return planService.allDrug();
    }
    /*新增采购计划*/
    @RequestMapping("add-plan")
    public void addplan(@RequestBody String str){
        System.err.println(str);
        YkDrugpurchasePlan drugpurchasePlan = JSON.parseObject(str, YkDrugpurchasePlan.class);
      planService.addplan(drugpurchasePlan);
//        planService.addplan(ykDrugpurchasePlan);
    }
}