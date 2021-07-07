package cn.gson.hisspring.model.pojos;

import lombok.Data;

//药品药房库存表

@Data//get  set方法
public class YfDruginventory {

  private long yfDrvenId;
  private long drugId;
  private String yfDrvenName;
  private long ykWareId;
  private String yfDrvenBatch;
  private long yfDrvenCount;
  private java.sql.Timestamp yfDrvenMftDate;
  private long supplierId;
  private String yfSupplierName;

}
