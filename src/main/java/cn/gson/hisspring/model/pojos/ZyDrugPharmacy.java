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

  private String dpMaxUnit;
  private Long dpMaxCount;
  private Long dpInventory;
  private Long drugId;
  private Double dpDrugPrice;
  private String dpMinUnit;
  private String dpDrugName;

  public ZyDrugPharmacy(long dpId, Long dpInventory) {
    this.dpId = dpId;
    this.dpInventory = dpInventory;
  }

  public ZyDrugPharmacy(String dpMaxUnit, Long dpMaxCount, Long dpInventory, Long drugId, Double dpDrugPrice, String dpMinUnit, String dpDrugName) {
    this.dpMaxUnit = dpMaxUnit;
    this.dpMaxCount = dpMaxCount;
    this.dpInventory = dpInventory;
    this.drugId = drugId;
    this.dpDrugPrice = dpDrugPrice;
    this.dpMinUnit = dpMinUnit;
    this.dpDrugName = dpDrugName;
  }

  public ZyDrugPharmacy() {
  }
}
