package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class HcApplyHost {

  private long applyId;
  private long sId;
  private java.sql.Timestamp applyTime;
  private double hostPhy;

}
