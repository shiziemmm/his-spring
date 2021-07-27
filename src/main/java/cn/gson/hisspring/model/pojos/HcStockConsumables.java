package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class HcStockConsumables {

  private long consumablesStockId;
  private long consumablesId;
  private long consumablesNumber;
  private java.sql.Timestamp stockConsumableTime;


}
