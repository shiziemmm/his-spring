package cn.gson.hisspring.model.pojos;


import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.sql.Timestamp;

/**
 * 发药记录
 */

@Data
public class YfDispensing {

  @TableId(value = "yk_dis_id")
  private long ykDisId;
  private java.sql.Timestamp ykDisDate;
  private String ykDisGo;
  private Long sId;
  private String ykDisName;
  private String yfDisDurgName;
  private Long yfDisDurgCount;
  private Long drugId;

  public Long getsId() {
    return sId;
  }

  public void setsId(Long sId) {
    this.sId = sId;
  }

  public YfDispensing() {
  }

  public YfDispensing(String ykDisGo, Long sId, String ykDisName, String yfDisDurgName, Long yfDisDurgCount, Long drugId) {
    this.ykDisDate = new Timestamp(new Date().getTime());
    this.ykDisGo = ykDisGo;
    this.sId = sId;
    this.ykDisName = ykDisName;
    this.yfDisDurgName = yfDisDurgName;
    this.yfDisDurgCount = yfDisDurgCount;
    this.drugId = drugId;
  }
}
