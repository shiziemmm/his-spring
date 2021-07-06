package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class Scheduling {

  private long scId;
  private java.sql.Timestamp scStartTime;
  private java.sql.Timestamp scEndTime;
  private java.sql.Timestamp scStartDate;
  private java.sql.Timestamp scEndDate;
  private long sId;
  private long fcId;


}
