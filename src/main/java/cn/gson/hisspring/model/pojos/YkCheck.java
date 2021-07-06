package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class YkCheck {

  private long ykCheckId;
  private long sId;
  private String ykCheckSname;
  private java.sql.Timestamp ykCheckDate;


}
