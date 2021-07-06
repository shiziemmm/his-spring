package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzRegistration {

  private long rtNumber;
  private double rtPrice;
  private String rtState;
  private String rtType;
  private String rtScience;
  private String rtDoctor;
  private java.sql.Timestamp rtTime;
  private java.sql.Timestamp rtOnsetTime;
  private String rtOverKsName;
  private long sId;
  private long sickNumber;
  private String mcNumberCard;


}
