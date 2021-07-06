package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzLaboratory {

  private long labNumber;
  private long sickNumber;
  private java.sql.Timestamp labTime;
  private long sId;
  private String labDoctorText;
  private long mrNumber;


}
