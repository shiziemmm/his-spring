package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ZyDoctorEnjoinExecuteRecord {

  @TableId("der_id")
  private long derId;
  private Long desId;
  private java.sql.Timestamp derExecuteDate;
  private Double derDrugPrice;
  private Long ptNo;
  private Long sId;
  private String derText;//说明



  public Long getSId() {
    return sId;
  }

  public void setSId(Long sId) {
    this.sId = sId;
  }

}
