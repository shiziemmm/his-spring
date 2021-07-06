package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyBedUseRecord {

  private long urId;
  private long bdId;
  private String ptNo;
  private java.sql.Timestamp urUseDate;
  private java.sql.Timestamp urEndDate;
  private double urBedPrice;


}
