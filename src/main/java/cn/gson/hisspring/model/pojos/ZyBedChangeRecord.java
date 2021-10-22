package cn.gson.hisspring.model.pojos;


import com.baomidou.mybatisplus.annotation.TableField;
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
  private String bcCause;//调换原因
  private Long sId;//操作人

  //关系
  @TableField(exist = false)
  private String beforeBdName;//转病房前病床名称
  @TableField(exist = false)
  private String afterBdName;//转病床后名称
  @TableField(exist = false)
  private String ptName;//病人名称
  @TableField
  private String sName;

  public ZyBedChangeRecord(Long bcCurrentBdId, Long bcLaterBdId, Timestamp bcDate, Long ptNo,Long sId,String bcCause) {
    this.bcCurrentBdId = bcCurrentBdId;
    this.bcLaterBdId = bcLaterBdId;
    this.bcDate = bcDate;
    this.ptNo = ptNo;
    this.sId = sId;
    this.bcCause = bcCause;
  }

  public ZyBedChangeRecord() {
  }
}
