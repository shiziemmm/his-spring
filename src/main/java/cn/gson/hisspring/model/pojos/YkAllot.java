package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class YkAllot {

  private long ykAllotId;
  private String ykAllotCause;
  private java.sql.Timestamp ykAllotTime;
  private long sId;
  private String ykAllotName;


}
