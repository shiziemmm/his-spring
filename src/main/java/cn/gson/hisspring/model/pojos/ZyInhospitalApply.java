package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyInhospitalApply {

  private long inId;
  private Long sickNumber;
  private String inDiagnosis;
  private java.sql.Timestamp inApplyDate;
  private Long ksId;
  private String ksName;
  private Long inProposer;
  private Long sId;
  private Long inIs;


}
