package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class RoleMiddleJurisdiction {
  @TableId(value = "r_id")
  private long rId;
  private long fctionId;
  @TableField(exist = false)
  List<FunctionJurisdiction> funs;

}
