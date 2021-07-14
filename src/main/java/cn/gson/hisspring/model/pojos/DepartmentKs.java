package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.OneToMany;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class DepartmentKs {
  @TableId(value = "ks_id")
  private long ksId;
  private String ksName;
  private long deId;

  @TableField(exist = false)
  private Department dept;

}
