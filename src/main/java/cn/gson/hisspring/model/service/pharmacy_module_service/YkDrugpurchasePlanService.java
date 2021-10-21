package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YkDrugpurchasePlanMapper;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.YfDruginformation;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlan;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlanDetails;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
    public List<YkDrugpurchasePlanDetails> allydpd(String ykPurchaseId){
        return planMapper.allydpd(ykPurchaseId);
    }
    /*查询药品信息*/
    public List<YfDruginformation> allDrug(){
        return planMapper.allDrug();
    }
    /*查询待入库的药品*/
    public List<YkDrugpurchasePlan> alldairuku(){
        return planMapper.alldairuku();
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
           details.setYkDrugName(list.getYkDrugName());
           planMapper.addplandeta(details);
        }
//        planMapper.addplan(ykDrugpurchasePlan);
    }

    /*执行采购计划 把状态修改成2*/
    /*public void zhixing(YkDrugpurchasePlan Drugpurchase){
        QueryWrapper qwra =new QueryWrapper();
        qwra.eq("YK_purchase_is",Drugpurchase.getYkPurchaseIs());
        YkDrugpurchasePlan ykDrugpurchasePlan = planMapper.selectOne(qwra);
        if (ykDrugpurchasePlan!=null){
            ykDrugpurchasePlan.setYkPurchaseIs(2L);
            planMapper.updateById(ykDrugpurchasePlan);
        }
    }*/
    /*执行采购计划*/
    public void zhixing (String ykPurchaseId){
         planMapper.zhixing(ykPurchaseId);
    }

    /*保存入库的药品*/
    public void preserve(List<YkDrugpurchasePlanDetails> ykDrugpurchasePlanDetails){
        YkDrugpurchasePlanDetails planDetails = new YkDrugpurchasePlanDetails();
        for (YkDrugpurchasePlanDetails ykDrugpurchasePlanDetail : ykDrugpurchasePlanDetails) {
            planDetails.setYkChaseId(ykDrugpurchasePlanDetail.getYkChaseId());
            planDetails.setYkBatch(ykDrugpurchasePlanDetail.getYkBatch());
            planDetails.setYkChaseCount(ykDrugpurchasePlanDetail.getYkChaseCount());
            planDetails.setYkDate(ykDrugpurchasePlanDetail.getYkDate());
            planMapper.preserve(planDetails);
        }

    }
}
