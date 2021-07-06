package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzCaseHistory {

  private long chNumber;
  private String chCause;
  private java.sql.Timestamp chTime;
  private String chText;
  private String chDoctor;
  private long sickNumber;


}
