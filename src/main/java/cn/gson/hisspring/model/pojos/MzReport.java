package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzReport {

  private long reportNumber;
  private String reportCard;
  private String reportTime;
  private long sId;
  private long sickNumber;
  private String reportCause;


}
