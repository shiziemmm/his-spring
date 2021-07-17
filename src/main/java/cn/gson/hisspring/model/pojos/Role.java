package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.Value;

import java.util.List;

@Data//get  set方法
public class Role {
  @TableId(value="r_id")
  private long rId;
  private String rName;
  private long roId;
  @TableField(exist = false)
  private Role roles;
}
