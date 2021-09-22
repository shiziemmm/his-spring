package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class ZyDoctorEnjoinExecuteRecord {

  @TableId("der_id")
  private long derId;
  private Long desId;
  private java.sql.Timestamp derExecuteDate;
  private Double derDrugPrice;
  private Long ptNo;
  private Long sId;
  private String derIs;//说明

  public ZyDoctorEnjoinExecuteRecord(Double derDrugPrice, Long ptNo, Long sId, String derText) {
    this.derExecuteDate = new Timestamp(new Date().getTime());
    this.derDrugPrice = derDrugPrice;
    this.ptNo = ptNo;
    this.sId = sId;
    this.derIs = derText;
  }

  public ZyDoctorEnjoinExecuteRecord() {
  }

  public Long getSId() {
    return sId;
  }

  public void setSId(Long sId) {
    this.sId = sId;
  }

}
