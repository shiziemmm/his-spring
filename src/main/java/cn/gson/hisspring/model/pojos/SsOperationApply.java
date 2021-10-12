package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data//get  set方法
public class SsOperationApply {
  @TableId(value = "apply_id",type = IdType.AUTO)
  private long applyId;
  private long ptNo;
  private String simulationOperation;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp simulationTime;
  private long sId;
  private long projectId;
  private long changeId;
  private long operationId;
  private long hocusId;
  private long applyZt;
  private long operationAnathe;
  private long operationHelper;
  private long operationDoctor;


  @TableField(exist = false)
  private ZyPatientBase ptdx;//病人信息
  @TableField(exist = false)
  private  Staff ys;//执行人员工信息
  @TableField(exist = false)
  private  Staff yh;//主刀医生员工信息
}
