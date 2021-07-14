package cn.gson.hisspring.model.pojos;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class ZyBedChangeRecord {

  @TableId("bc_id")
  private long bcId;


  private Long bcCurrentBdId;
  private Long bcLaterBdId;
  private java.sql.Timestamp bcDate;
  private Long ptNo;

  public ZyBedChangeRecord(Long bcCurrentBdId, Long bcLaterBdId, Timestamp bcDate, Long ptNo) {
    this.bcId = bcId;
    this.bcCurrentBdId = bcCurrentBdId;
    this.bcLaterBdId = bcLaterBdId;
    this.bcDate = bcDate;
    this.ptNo = ptNo;
  }

  public ZyBedChangeRecord() {
  }
}
