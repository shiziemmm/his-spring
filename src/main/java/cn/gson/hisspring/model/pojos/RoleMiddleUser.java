package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class RoleMiddleUser {

  private long uId;
  private long rId;
  @TableField(exist = false)
  List<RoleMiddleUser> funs;


}
