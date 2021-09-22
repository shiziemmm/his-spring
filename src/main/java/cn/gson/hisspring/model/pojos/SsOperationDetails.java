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
  private long hocusId;

  @TableField(exist = false)
  private YfDruginformation yfdx;//药房信息
  @TableField(exist = false)
  private SsOperationProject ssdx;//手术信息
  @TableField(exist = false)
  private ZyPatientBase ptdx;//病人信息
}
