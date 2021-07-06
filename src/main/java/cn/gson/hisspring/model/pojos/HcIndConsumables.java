package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class HcIndConsumables {

  private long consumablesId;
  private String consumablesName;
  private long consumablesPhy;
  private java.sql.Timestamp consumablesPurchase;


}
