package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data//get  set方法
public class ZyPay {

  @TableId("py_id")
  private long pyId;
  private Double pyPrice;
  private java.sql.Timestamp pyDate;
  private Long ptNo;
  private Long sId;

  public ZyPay() {
  }

  public ZyPay(Double pyPrice, Timestamp pyDate, Long ptNo, Long sId) {
    this.pyPrice = pyPrice;
    this.pyDate = pyDate;
    this.ptNo = ptNo;
    this.sId = sId;
  }
}
