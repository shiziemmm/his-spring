package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 住院科室药品库存表实体类
 */
@Data
public class ZyDrugPharmacy {

  @TableId(value = "dp_id")
  private long dpId;

  private Long ksId;
  private String dpMaxUnit;
  private Double dpMaxCount;
  private Long dpInventory;
  private Long drugId;
  private Double dpDrugPrice;
  private String dpMinUnit;
  private String dpDrugName;
  private Integer dpGuard;//库存警戒线


  public ZyDrugPharmacy(long dpId, Integer dpGuard) {
    this.dpId = dpId;
    this.dpGuard = dpGuard;
  }

  public ZyDrugPharmacy() {
  }
}
