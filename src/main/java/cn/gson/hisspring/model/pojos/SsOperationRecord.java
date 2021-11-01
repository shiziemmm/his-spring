package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class SsOperationRecord {

    private long recordId;
    private long operationId;
    private java.sql.Timestamp recordTime;
    private long projectId;


}
