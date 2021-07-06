package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyPay {

  private long pyId;
  private double pyPrice;
  private java.sql.Timestamp pyDate;
  private long ptNo;
  private long sId;


}
