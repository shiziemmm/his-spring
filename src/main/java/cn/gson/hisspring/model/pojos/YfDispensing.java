package cn.gson.hisspring.model.pojos;

import lombok.Data;

//发药表

@Data//get  set方法
public class YfDispensing {

  private long ykDisId;
  private java.sql.Timestamp ykDisDate;
  private String ykDisGo;
  private long sId;
  private String ykDisName;
  private long recipeNumber;


}
