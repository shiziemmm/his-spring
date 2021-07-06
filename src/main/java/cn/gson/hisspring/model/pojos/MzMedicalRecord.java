package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzMedicalRecord {

  private long mrNumber;
  private String mrDoctorName;
  private String mrDiagnoseRecord;
  private java.sql.Timestamp mrSection;
  private String mrKsName;
  private String mrPhone;
  private long sId;
  private String sickNumber;
  private String mcNumberCard;


}
