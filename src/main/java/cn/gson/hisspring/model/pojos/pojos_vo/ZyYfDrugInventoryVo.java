package cn.gson.hisspring.model.pojos.pojos_vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 药房
 */
@Data
@TableName(value = "YF_DrugInventory")
public class ZyYfDrugInventoryVo {

  @TableId(value = "yf_drven_id")
  private long yfDrvenId;
  private Long drugId;
  private String yfDrvenName;
  private Long yfDrvenCount;
  private Long supplierId;
  private String yfSupplierName;
  private String yfDrcaName;
  private String drugPrescription;

  public ZyYfDrugInventoryVo(long yfDrvenId, Long yfDrvenCount) {
    this.yfDrvenId = yfDrvenId;
    this.yfDrvenCount = yfDrvenCount;
  }

  public ZyYfDrugInventoryVo() {
  }
}
