package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class YkDruginventory {

  private long ykDrvenId;
  private long drugId;
  private String ykDrvenName;
  private long ykWareId;
  private String ykDrvenBatch;
  private long ykDrvenCount;
  private java.sql.Timestamp ykDrvenMftDate;
  private long supplierId;
  private String ykSupplierName;


}
