package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data//get  set方法
public class SsOperationDetails {

  private long operationNum;
  private String operationTime;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp operationDate;
  private long projectId;
  private String operationHandle;
  private long operationHocus;
  private long operationDoctor;
  private long ptNo;
  private long hocusId;
  private long operationAnathe;
  private long operationHelper;
  private String simulationOperation;
  @TableField(exist = false)
  private String operationAnaesthesia;

  @TableField(exist = false)
  private YfDruginformation yfdx;//药房信息
  @TableField(exist = false)
  private SsOperationProject ssdx;//手术信息
  @TableField(exist = false)
  private ZyPatientBase ptdx;//病人信息
}
