package cn.gson.hisspring.model.pojos;

import lombok.Data;

//盘点表

@Data//get  set方法
public class YkCheck {

  private long ykCheckId;
  private long sId;
  private String ykCheckSname;
  private java.sql.Timestamp ykCheckDate;


}
