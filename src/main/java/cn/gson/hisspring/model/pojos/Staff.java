package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.OneToMany;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data//get  set方法
public class Staff {
@TableId(type = IdType.AUTO)
  private long sId;
  private String sName;
  private String sSore;
  private String sPhone;
  private Date sDate;
  private Long uId;
  private Long ksId;
  private Long tId;
  private Long sZt;
  @TableField(exist = false)
  private Long deptId;

  @TableField(exist = false)
  private User user;

  @TableField(exist = false)
  private DepartmentKs ks;

  @TableField(exist = false)
  private  Title t;

  @TableField(exist = false)
  private Role role;

  @TableField(exist = false)
  private Department dept;

  @TableField(exist = false)
  private Register register;

  @Override
  public String toString() {
    return "Staff{" +
            "sId=" + sId +
            ", sName='" + sName + '\'' +
            ", sSore='" + sSore + '\'' +
            ", sPhone='" + sPhone + '\'' +
            ", sDate=" + sDate +
            ", uId=" + uId +
            ", ksId=" + ksId +
            ", tId=" + tId +
            ", sZt=" + sZt +
            ", user=" + user +
            ", ks=" + ks +
            ", t=" + t +
            ", role=" + role +
            ", dept=" + dept +
            '}';
  }
}
