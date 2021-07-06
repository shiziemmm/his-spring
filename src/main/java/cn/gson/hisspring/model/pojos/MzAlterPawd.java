package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzAlterPawd {

  private long apNumber;
  private String apCause;
  private java.sql.Timestamp apTime;
  private long sId;
  private long mcNumberCard;
  private long sickNumber;


}
