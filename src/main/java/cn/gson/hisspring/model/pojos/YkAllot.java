package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

//调拨申请表

public class YkAllot {

  private String ykAllotId;//调拨编号
  private String ykAllotCause;//调拨原因
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private java.sql.Timestamp ykAllotTime;//调拨时间
  private long sId;//连接 用户表 用户编号
  private String ykAllotName;//用户名称

  @TableField(exist = false)
  private Staff staff;//员工表
  @TableField(exist = false)
  private List<YkAllotdetail> ykAllotdetail;//调拨详表

  @TableField(exist = false)
  private List<YfDruginventory> yfDruginventories;//药房库存

  public List<YfDruginventory> getYfDruginventories() {
    return yfDruginventories;
  }

  public void setYfDruginventories(List<YfDruginventory> yfDruginventories) {
    this.yfDruginventories = yfDruginventories;
  }

  public String getYkAllotId() {
    return ykAllotId;
  }

  public void setYkAllotId(String ykAllotId) {
    this.ykAllotId = ykAllotId;
  }

  public String getYkAllotCause() {
    return ykAllotCause;
  }

  public void setYkAllotCause(String ykAllotCause) {
    this.ykAllotCause = ykAllotCause;
  }

  public Timestamp getYkAllotTime() {
    return ykAllotTime;
  }

  public void setYkAllotTime(Timestamp ykAllotTime) {
    this.ykAllotTime = ykAllotTime;
  }

  public long getsId() {
    return sId;
  }

  public void setsId(long sId) {
    this.sId = sId;
  }

  public String getYkAllotName() {
    return ykAllotName;
  }

  public void setYkAllotName(String ykAllotName) {
    this.ykAllotName = ykAllotName;
  }

  public Staff getStaff() {
    return staff;
  }

  public void setStaff(Staff staff) {
    this.staff = staff;
  }

  public List<YkAllotdetail> getYkAllotdetail() {
    return ykAllotdetail;
  }

  public void setYkAllotdetail(List<YkAllotdetail> ykAllotdetail) {
    this.ykAllotdetail = ykAllotdetail;
  }

  @Override
  public String toString() {
    return "YkAllot{" +
            "ykAllotId='" + ykAllotId + '\'' +
            ", ykAllotCause='" + ykAllotCause + '\'' +
            ", ykAllotTime=" + ykAllotTime +
            ", sId=" + sId +
            ", ykAllotName='" + ykAllotName + '\'' +
            ", staff=" + staff +
            ", ykAllotdetail=" + ykAllotdetail +
            ", yfDruginventories=" + yfDruginventories +
            '}';
  }
}
