package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class SsOperationApply {

  private long applyId;
  private long ptNo;
  private String simulationOperation;
  private long sId;
  private long projectId;
  private long changeId;
  private long operationId;


}
