package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.OneToMany;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class Staff {
@TableId(type = IdType.AUTO)
  private long sId;
  private String sName;
  private String sSore;
  private String sPhone;
  private java.sql.Timestamp sDate;
  private Long uId;
  private Long ksId;
  private Long tId;
  private long sZt;
  private User user;
  private DepartmentKs ks;
  private  Title t;
  private Role role;
  private Department dept;



}
