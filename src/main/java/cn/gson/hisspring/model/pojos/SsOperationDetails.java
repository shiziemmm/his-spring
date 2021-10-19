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
  private Long projectId;
  private String operationHandle;
  private Long operationHocus;
  private Long operationDoctor;
  private Long ptNo;
  private Long hocusId;
  private Long operationAnathe;
  private Long operationHelper;
  private String simulationOperation;
  @TableField(exist = false)
  private String operationAnaesthesia;

  @TableField(exist = false)
  private YfDruginformation yfdx;//药房信息
  @TableField(exist = false)
  private SsOperationProject ssdx;//手术信息
  @TableField(exist = false)
  private ZyPatientBase ptdx;//病人信息
  @TableField(exist = false)
  private Staff zd;//主刀
  @TableField(exist = false)
  private Staff mz;//麻醉
  @TableField(exist = false)
  private Staff zs;//助手
}
