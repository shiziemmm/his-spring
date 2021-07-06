package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzOpcNumber {

  private long bnNumber;
  private long bnState;
  private String bnCount;
  private java.sql.Timestamp bnTime;
  private String bnSickName;
  private long rtNumber;
  private String mrNumber;


}
