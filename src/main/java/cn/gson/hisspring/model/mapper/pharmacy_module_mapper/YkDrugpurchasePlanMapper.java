package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.YfDruginformation;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlan;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlanDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YkDrugpurchasePlanMapper extends BaseMapper<YkDrugpurchasePlan> {
    //查询采购计划
    List <YkDrugpurchasePlan> allplan();
    //查询采购的员工
    List <Staff> staff();
    //查询采购计划详单
    List <YkDrugpurchasePlanDetails> allydpd(String ykPurchaseId);
    //查询药品信息
    List <YfDruginformation> allDrug();
    //新增采购计划
    void addplan(YkDrugpurchasePlan ykDrugpurchasePlan);
    /*新增采购详单*/
    void  addplandeta(YkDrugpurchasePlanDetails ykDrugpurchasePlanDetails);
    /*查询待入库的药品*/
    List <YkDrugpurchasePlan>alldairuku();
    /*执行采购计划*/
    void zhixing(String ykPurchaseId);
    /*保存入库的药品*/
    void preserve(YkDrugpurchasePlanDetails ykDrugpurchasePlanDetails);
}
