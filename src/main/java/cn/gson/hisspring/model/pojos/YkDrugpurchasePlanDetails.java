package cn.gson.hisspring.model.pojos;

import lombok.Data;

//药品采购计划详单

@Data//get  set方法
public class YkDrugpurchasePlanDetails {

  private long ykChaseId;
  private long drugId;
  private long ykPurchaseId;
  private String ykDrugName;
  private long ykChaseCount;


}
