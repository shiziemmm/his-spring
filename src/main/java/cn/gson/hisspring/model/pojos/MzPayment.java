package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzPayment {

  private long pmNumber;
  private long mrNumbe;
  private String pmBillCode;
  private String pmBillNumber;
  private java.sql.Timestamp pmTime;
  private String pmName;
  private double pmPrice;
  private double pmSum;
  private String pmPriceType;
  private long mcNumberCard;
  private String sickNumber;
  private long sId;


}
