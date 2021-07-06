package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class SsOperationDetails {

  private long operationNum;
  private String operationPosition;
  private java.sql.Timestamp operationDate;
  private long projectId;
  private String operationHandle;
  private String operationHocus;
  private String operationCut;
  private String operationDoctorName;
  private long ptNo;


}
