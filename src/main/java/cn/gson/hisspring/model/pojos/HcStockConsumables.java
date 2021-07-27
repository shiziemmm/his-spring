package cn.gson.hisspring.model.pojos;

import lombok.Data;

//耗材库存表

@Data//get  set方法
public class HcStockConsumables {

  private long consumablesStockId;
  private long consumablesId;//连接耗材表id
  private long consumablesNumber;//耗材数量
  private java.sql.Timestamp stockConsumableTime;//保质期


}
