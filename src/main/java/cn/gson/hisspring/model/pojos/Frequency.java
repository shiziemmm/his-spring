package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data//get  set方法
public class Frequency {
  @TableId(value = "f_id")
  private long fId;
  private String fFrequency;
  private String fStartTime;
  private String fEndTime;
  private long fZt;

}
