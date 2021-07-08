package cn.gson.hisspring.model.pojos;

import lombok.Data;

//调拨申请表

@Data//get  set方法
public class YkAllot {

  private long ykAllotId;
  private String ykAllotCause;
  private java.sql.Timestamp ykAllotTime;
  private long sId;
  private String ykAllotName;


}
