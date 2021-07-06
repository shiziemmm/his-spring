package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class SsOperationRoom {

  private long operationId;
  private String operationName;
  private String operationZt;
  private String operationRoomAddress;
  private long sId;
  private String operationType;

}
