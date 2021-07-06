package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class TjManResult {

  private long manResultId;
  private long checkId;
  private String manResult;
  private long manId;
  private java.sql.Timestamp manDate;

}
