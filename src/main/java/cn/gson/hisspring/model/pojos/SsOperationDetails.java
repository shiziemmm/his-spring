package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data//get  set方法
public class SsOperationDetails {

  private long operationNum;
  private String OperationTime;
  private java.sql.Timestamp operationDate;
  private long projectId;
  private String operationHandle;
  private String operationHocus;
  private String operationDoctorName;
  private long ptNo;

  @TableField(exist = false)
  private SsOperationProject ssdx;//手术信息
  @TableField(exist = false)
  private ZyPatientBase ptdx;//病人信息
}
