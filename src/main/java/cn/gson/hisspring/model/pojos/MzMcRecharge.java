package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzMcRecharge {

  private long mcrcNumber;
  private double mcrcPrice;
  private java.sql.Timestamp mcrcTime;
  private String mcNumberCard;
  private String mcrcPayment;
  private long sId;


}
