package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class Department {

  private long deId;
  private String deName;
  private java.sql.Timestamp deDate;



}
