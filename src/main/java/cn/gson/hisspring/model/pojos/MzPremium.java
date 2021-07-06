package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzPremium {

  private long premiumNumbe;
  private String premiumName;
  private String premiumCause;
  private double premiumPrice;
  private java.sql.Timestamp premiumTime;
  private long sId;
  private long mcNumberCard;
  private String sickNumber;


}
