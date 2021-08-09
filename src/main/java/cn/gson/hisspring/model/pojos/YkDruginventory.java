package cn.gson.hisspring.model.pojos;

import lombok.Data;

//药品药库库存表

@Data//get  set方法
public class YkDruginventory {

  private long ykDrvenId;//药品库存编号
  private long drugId;//药品编号
  private String ykDrvenName;//药品名称
  private long ykWareId;//仓库编号
  private String ykDrvenBatch;//药品批次
  private long ykDrvenCount;//药品库存 药品数量
  private java.sql.Timestamp ykDrvenMftDate;//生产日期
  private long supplierId;//供应商编号
  private String ykSupplierName;//供应商名称

  private YkWarehouse ykWarehouse;//仓库
  private YkDrugpurchasePlan ykDrugpurchasePlan;//采购
}
