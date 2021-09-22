package cn.gson.hisspring.model.pojos;

import lombok.Data;

/**
 * 检验项目中间表
 */

@Data//get  set方法
public class MzCentreLabwork {

  private long labNumber;
  private long checkId;
  private String labDoctorText;

}
