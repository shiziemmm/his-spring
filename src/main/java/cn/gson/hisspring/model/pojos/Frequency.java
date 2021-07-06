package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class Frequency {

  private long fId;
  private String fFrequency;
  private java.sql.Timestamp fStartTime;
  private java.sql.Timestamp fEndTime;
  private long fcId;

}
