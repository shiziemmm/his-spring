package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
//import sun.rmi.runtime.Log;

import java.sql.Timestamp;

//药品药房库存表

@Data//get  set方法
@TableName(value = "yf_druginventory")
public class YfDruginventory {

  @TableId(type = IdType.AUTO)
  @TableField(value ="yf_Drven_Id" )
  private Long yfDrvenId;//药品库存编号
  private Long drugId;//药品编号
  private String yfDrvenName;//药品名称
  private Long yfDrvenCount;//药品库存  数量
  private Long supplierId;//连接供应商表 供应商编号
  private String yfSupplierName;//供应商名称
  private String yfDrcaName;//药品类别
  private String drugPrescription;//处方药
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Timestamp yfDrvenMftdate;//生产日期
  private String yfDrvenBatch;//药品批次
  private Double yfSellingprice;//药品售价

  @TableField(exist = false)
  private YkSupplier ykSupplier;//供应商
  @TableField(exist = false)
  private YfDruginformation yfDruginformation;//药品信息
  @TableField(exist = false)
  private YfDrugcategory yfDrugcategory;//药品类别
  @TableField(exist = false)
  private Integer yfNumbers;
  @TableField(exist = false)
  private YkAllot ykAllot;

  public Long getYfDrvenId() {
    return yfDrvenId;
  }

  public void setYfDrvenId(Long yfDrvenId) {
    this.yfDrvenId = yfDrvenId;
  }

  public Long getYfDrvenCount() {
    return yfDrvenCount;
  }

  public void setYfDrvenCount(Long yfDrvenCount) {
    this.yfDrvenCount = yfDrvenCount;
  }

  public YkAllot getYkAllot() {
    return ykAllot;
  }

  public void setYkAllot(YkAllot ykAllot) {
    this.ykAllot = ykAllot;
  }

  public Long getDrugId() {
    return drugId;
  }

  public void setDrugId(Long drugId) {
    this.drugId = drugId;
  }

  public String getYfDrvenName() {
    return yfDrvenName;
  }

  public void setYfDrvenName(String yfDrvenName) {
    this.yfDrvenName = yfDrvenName;
  }



  public String getYfDrvenBatch() {
    return yfDrvenBatch;
  }

  public void setYfDrvenBatch(String yfDrvenBatch) {
    this.yfDrvenBatch = yfDrvenBatch;
  }

  public YfDruginventory() {
  }

  public YfDruginventory(Long yfDrvenId, Long yfDrvenCount) {
    this.yfDrvenId = yfDrvenId;
    this.yfDrvenCount = yfDrvenCount;
  }
}
