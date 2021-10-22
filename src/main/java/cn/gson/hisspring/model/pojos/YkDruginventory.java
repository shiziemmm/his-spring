package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
//import sun.rmi.runtime.Log;

import java.sql.Timestamp;

//药品药库库存表

@Data//get  set方法
@TableName(value = "yk_druginventory")
public class YkDruginventory {

  @TableId
  @TableField(value = "yk_Drven_Id")
  private long ykDrvenId;//药品库存编号

  private Long drugId;//药品编号
  private String ykDrvenName;//药品名称
  private Long ykWareId;//仓库编号
  private String ykDrvenBatch;//药品批次
  private Long ykDrvenCount;//药品库存 药品数量
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Timestamp ykDrvenMftdate;//生产日期
  private Long supplierId;//供应商编号
  private String ykSupplierName;//供应商名称
  private Double ykSellingprice;//药品售价


  @TableField(exist = false)
  private YkWarehouse ykWarehouse;//仓库
  @TableField(exist = false)
  private YkSupplier ykSupplier;//供应商

  public YkDruginventory(long ykDrvenId, Long ykDrvenCount) {
    this.ykDrvenId = ykDrvenId;
    this.ykDrvenCount = ykDrvenCount;
  }

  public YkDruginventory() {
  }





  public long getYkDrvenId() {
    return ykDrvenId;
  }

  public void setYkDrvenId(long ykDrvenId) {
    this.ykDrvenId = ykDrvenId;
  }

  public Long getDrugId() {
    return drugId;
  }

  public void setDrugId(Long drugId) {
    this.drugId = drugId;
  }

  public String getYkDrvenName() {
    return ykDrvenName;
  }

  public void setYkDrvenName(String ykDrvenName) {
    this.ykDrvenName = ykDrvenName;
  }

  public Long getYkWareId() {
    return ykWareId;
  }

  public void setYkWareId(Long ykWareId) {
    this.ykWareId = ykWareId;
  }

  public String getYkDrvenBatch() {
    return ykDrvenBatch;
  }

  public void setYkDrvenBatch(String ykDrvenBatch) {
    this.ykDrvenBatch = ykDrvenBatch;
  }

  public Long getYkDrvenCount() {
    return ykDrvenCount;
  }

  public void setYkDrvenCount(Long ykDrvenCount) {
    this.ykDrvenCount = ykDrvenCount;
  }

  public Timestamp getYkDrvenMftdate() {
    return ykDrvenMftdate;
  }

  public void setYkDrvenMftdate(Timestamp ykDrvenMftdate) {
    this.ykDrvenMftdate = ykDrvenMftdate;
  }

  public Long getSupplierId() {
    return supplierId;
  }

  public void setSupplierId(Long supplierId) {
    this.supplierId = supplierId;
  }

  public String getYkSupplierName() {
    return ykSupplierName;
  }

  public void setYkSupplierName(String ykSupplierName) {
    this.ykSupplierName = ykSupplierName;
  }

  public Double getYkSelingprice() {
    return ykSellingprice;
  }

  public void setYkSelingprice(Double ykSelingprice) {
    this.ykSellingprice = ykSelingprice;
  }

  public YkDruginventory(long ykDrvenId, Long drugId, String ykDrvenName, Long ykWareId, String ykDrvenBatch, Long ykDrvenCount, Timestamp ykDrvenMftdate, Long supplierId, String ykSupplierName, Double ykSellingprice, YkWarehouse ykWarehouse, YkSupplier ykSupplier) {
    this.ykDrvenId = ykDrvenId;
    this.drugId = drugId;
    this.ykDrvenName = ykDrvenName;
    this.ykWareId = ykWareId;
    this.ykDrvenBatch = ykDrvenBatch;
    this.ykDrvenCount = ykDrvenCount;
    this.ykDrvenMftdate = ykDrvenMftdate;
    this.supplierId = supplierId;
    this.ykSupplierName = ykSupplierName;
    this.ykSellingprice = ykSellingprice;
    this.ykWarehouse = ykWarehouse;
    this.ykSupplier = ykSupplier;
  }
}
