package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ApprovalRecord {

  private long arId;
  private long aId;
  private long sId;
  private String arOpinion;
  private java.sql.Timestamp arDate;
  private String arOperation;


}
