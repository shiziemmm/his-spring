package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.OneToMany;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class DepartmentKs{

  private long ksId;
  private String ksName;
  private long deId;


}
