package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

/**
 * 手术中间表
 */
@Data
public class MzCenterSurgery {

  private long projectId;
  private long susNumber;
  private java.sql.Timestamp startDate;
  private java.sql.Timestamp overDate;
  private String susMessage;
  private String susDoctorText;

  @TableField(exist = false)
  private SsOperationProject ssObject;


}
