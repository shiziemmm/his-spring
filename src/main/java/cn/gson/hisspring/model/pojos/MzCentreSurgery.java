package cn.gson.hisspring.model.pojos;

import lombok.Data;

/**
 * 门诊手术记录中间表
 */
@Data//get  set方法
public class MzCentreSurgery {
  private long susNumber;
  private long projectId;
  private String susDoctorText;



}
