package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyDoctorEnjoinDetails {

  private long desId;
  private long deId;
  private long drugId;
  private String desDrugName;
  private String desText;
  private long checkId;
  private String desSpecification;
  private String desMeasure;
  private String desUnit;
  private String desUsage;
  private double desPrice;
  private long sId;
  private String desNurseName;
  private java.sql.Timestamp desDate;
  private long desIs;
  private java.sql.Timestamp desExecuteDate;
  private java.sql.Timestamp desEndDate;
  private java.sql.Timestamp desPresentDate;

}
