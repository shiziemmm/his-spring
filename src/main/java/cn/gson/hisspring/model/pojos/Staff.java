package cn.gson.hisspring.model.pojos;

import lombok.Data;

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
