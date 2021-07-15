package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data//get  set方法
public class ZyInhospitalApply {

  @TableId("in_id")
  private long inId;
  private Long sickNumber;
  private String inDiagnosis;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp inApplyDate;
  private Long ksId;
  private String ksName;
  private Long inProposer;
  private Long sId;
  private Long inIs;

  //关系
  @TableField(exist = false)
  private MzSick sick;//门诊病人信息对象

  @TableField(exist = false)
  private Staff staff;//员工对象

  public ZyInhospitalApply(long inId, Long inIs) {
    this.inId = inId;
    this.inIs = inIs;
  }

  public ZyInhospitalApply() {
  }
}
