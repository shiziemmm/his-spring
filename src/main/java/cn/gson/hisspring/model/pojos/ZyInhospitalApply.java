package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyInhospitalApply {

  private long inId;
  private long sickNumber;
  private String inDiagnosis;
  private java.sql.Timestamp inApplyDate;
  private long ksId;
  private String ksName;
  private long inProposer;
  private long sId;
  private long inIs;


}
