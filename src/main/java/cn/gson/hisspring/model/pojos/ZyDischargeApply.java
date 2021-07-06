package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyDischargeApply {

  private long dgaId;
  private String dagCause;
  private java.sql.Timestamp dagDate;
  private long ptNo;
  private long sId;
  private String dgaIs;
  private String dgaNoCause;



}
