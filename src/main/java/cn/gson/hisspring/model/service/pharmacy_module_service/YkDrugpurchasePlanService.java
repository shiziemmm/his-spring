package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YkDrugpurchasePlanMapper;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.YfDruginformation;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlan;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlanDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YkDrugpurchasePlanService {
    @Autowired
    YkDrugpurchasePlanMapper planMapper;
    /*查询所有的采购计划*/
    public List<YkDrugpurchasePlan> allplan(){
        return planMapper.allplan();
    }
    /*查询采购的员工*/
    public List<Staff> staff(){
        return planMapper.staff();
    }
    /*查询采购计划详单*/
    public List<YkDrugpurchasePlanDetails> allydpd(){
        return planMapper.allydpd();
    }
    /*查询药品信息*/
    public List<YfDruginformation> allDrug(){
        return planMapper.allDrug();
    }
    /*新增采购计划*/
    public void addplan(YkDrugpurchasePlan ykDrugpurchasePlan){

        YkDrugpurchasePlan drugpurchasePlan=new YkDrugpurchasePlan();
        drugpurchasePlan.setYkPurchaseId(ykDrugpurchasePlan.getYkPurchaseId());
        drugpurchasePlan.setSId(ykDrugpurchasePlan.getSId());
        drugpurchasePlan.setYkPurchaseName(ykDrugpurchasePlan.getYkPurchaseName());
//        drugpurchasePlan.setYkPurchaseSName(ykDrugpurchasePlan.getYkPurchaseSName());
        planMapper.addplan(drugpurchasePlan);

        for (YkDrugpurchasePlanDetails list : ykDrugpurchasePlan.getYkDrugpurchasePlanDetails()) {
            YkDrugpurchasePlanDetails details=new YkDrugpurchasePlanDetails();
            details.setDrugPrice(list.getDrugPrice());
           details.setYkChaseCount(list.getYkChaseCount());
           details.setDrugId(list.getDrugId());
           details.setYkPurchaseId(ykDrugpurchasePlan.getYkPurchaseId());
           planMapper.addplandeta(details);
        }
//        planMapper.addplan(ykDrugpurchasePlan);
    }
}
