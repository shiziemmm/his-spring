package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data//get  set方法
public class ZyDischargeApply {

  @TableId("dga_id")
  private long dgaId;

  private String dgaCause;
  private java.sql.Timestamp dgaDate;
  private Long ptNo;
  private Long sId;
  private String dgaIs;
  private String dgaNoCause;


  public ZyDischargeApply(Long ptNo, String dgaIs) {
    this.ptNo = ptNo;
    this.dgaIs = dgaIs;
  }

  public ZyDischargeApply() {
  }
}
