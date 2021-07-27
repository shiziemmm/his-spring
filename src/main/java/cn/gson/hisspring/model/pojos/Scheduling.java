package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data//get  set方法
public class Scheduling {
@TableId(value = "sc_id")
  private long scId;
  private java.sql.Timestamp scStartDate;
  private java.sql.Timestamp scEndDate;
  private long sId;
  private long fcId;


}
