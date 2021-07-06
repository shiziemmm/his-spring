package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzCentreSurgery {

  private long susNumber;
  private long projectId;
  private java.sql.Timestamp susDate;
  private String susRemark;



}
