package cn.gson.hisspring.model.pojos.pojos_vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 药房
 */
@Data
@TableName(value = "YF_DrugInventory")
public class ZyYfDrugInventoryVo {

  @TableId(value = "yf_drven_id")
  private long yfDrvenId;
  private Long drugId;//药品编号
  private String yfDrvenName;//药品名称
  private Long yfDrvenCount;//药品库存  数量
  private Long supplierId;//连接供应商表 供应商编号
  private String yfSupplierName;//供应商名称
  private String yfDrcaName;//药品类别
  private String drugPrescription;//处方药
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Timestamp yfDrvenMftdate;//生产日期
  private String yfDrvenBatch;//批次

  public ZyYfDrugInventoryVo(long drugId, String yfDrvenName, long yfDrvenCount, long supplierId) {
    this.drugId = drugId;
    this.yfDrvenName = yfDrvenName;
    this.yfDrvenCount = yfDrvenCount;
    this.supplierId = supplierId;
  }

  public ZyYfDrugInventoryVo(long yfDrvenId, Long yfDrvenCount) {
    this.yfDrvenId = yfDrvenId;
    this.yfDrvenCount = yfDrvenCount;
  }

  public ZyYfDrugInventoryVo() {

  }
}
