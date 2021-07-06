package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzTestNumber {

  private long testNumber;
  private String testState;
  private String testCount;
  private java.sql.Timestamp testTime;
  private String testSickName;
  private long mrNumber;


}
