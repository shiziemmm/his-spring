package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ZyDoctorEnjoinExecuteRecord {

  @TableId("der_id")
  private long derId;
  private long desId;
  private java.sql.Timestamp derExecuteDate;
  private Double derDrugPrice;
  private long ptNo;
  private long sId;



  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }

}
