package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.OneToMany;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class Staff {

  private long sId;
  private String sName;
  private String sSore;
  private String sPhone;
  private java.sql.Timestamp sDate;
  private Long uId;
  private Long ksId;
  private Long tId;



}
