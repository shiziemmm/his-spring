package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

//调拨申请表

@Data//get  set方法
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
}
