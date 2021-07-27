package cn.gson.hisspring.model.pojos;

import lombok.Data;

//耗材表

@Data//get  set方法
public class HcIndConsumables {

  private long consumablesId;
  private String consumablesName;//耗材名称
  private long consumablesPhy;//耗材数量
  private java.sql.Timestamp consumablesPurchase;//保质期


}
