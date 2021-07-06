package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyArrearage {

  private long agId;
  private long ptNo;
  private double agPrice;
  private java.sql.Timestamp agDate;
  private String agIPhone;
  private long agUrgeCount;



}
