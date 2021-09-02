package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class Frequency {
  @TableId(value = "f_id")
  private long fId;
  private String fStartTime;
  private String fEndTime;
  private long fcId;
  @TableField(exist = false)
  private FrequencyCategory fc;

}
