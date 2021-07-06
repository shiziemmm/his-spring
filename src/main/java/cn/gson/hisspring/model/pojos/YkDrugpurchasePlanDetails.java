package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class YkDrugpurchasePlanDetails {

  private long ykChaseId;
  private long drugId;
  private long ykPurchaseId;
  private String ykDrugName;
  private long ykChaseCount;


}
