package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 科室库存出入库记录实体类
 */
@Data
public class ZyDrugPharmacyOpRecord {

  @TableId(value = "dpor_id")
  private long dporId;

  private Long dporIs;
  private String dporCause;
  private Long dporSid;
  private java.sql.Timestamp dporDate;
  private Long drugId;
  private Double dporCount;
  private String dporDrugUnit;
}
