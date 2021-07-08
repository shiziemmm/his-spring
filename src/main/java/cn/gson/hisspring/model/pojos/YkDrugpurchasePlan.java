package cn.gson.hisspring.model.pojos;

import lombok.Data;

//药品采购计划表

@Data//get  set方法
public class YkDrugpurchasePlan {

  private long ykPurchaseId;
  private String ykPurchaseName;
  private java.sql.Timestamp ykPurchaseTime;
  private long sId;
  private String ykPurchaseSName;
  private long ykPurchaseIs;


}
