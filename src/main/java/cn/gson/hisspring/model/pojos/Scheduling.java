package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class Scheduling {
@TableId(value = "sc_id")
  private long scId;
  private long sId;
  private long frId;
  private String rq;

  @TableField(exist = false)
  private Staff staff;
  @TableField(exist = false)
  private List<Integer> list;
}
