package cn.gson.hisspring.model.pojos;

import lombok.Data;

//采购退货表

@Data//get  set方法
public class YkPurchaseReturn {

  private long ykReturnId;
  private java.sql.Timestamp ykReturnTime;
  private long sId;
  private String ykReturnName;

}
