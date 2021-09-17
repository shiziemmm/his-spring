package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 药房发药记录
 */
@Data
public class YfDispensing {

  @TableId(value = "yf_dis_id")
  private long yfDisId;
  private java.sql.Timestamp yfDisDate;
  private String yfDisGo;
  private Long sId;
  private String yfDisName;
  private String yfDisDurgName;
  private Long yfDisDurgCount;
  private Long drugId;
  private Long yfDrugIs;




  public void setsId(Long sId) {
    this.sId = sId;
  }

  public YfDispensing() {
  }

  public YfDispensing(String ykDisGo, Long sId, String ykDisName, String yfDisDurgName, Long yfDisDurgCount, Long drugId,Long is) {
    this.yfDisDate = new Timestamp(new Date().getTime());
    this.yfDisGo = ykDisGo;
    this.sId = sId;
    this.yfDisName = ykDisName;
    this.yfDisDurgName = yfDisDurgName;
    this.yfDisDurgCount = yfDisDurgCount;
    this.drugId = drugId;
    this.yfDrugIs = is;
  }
}
