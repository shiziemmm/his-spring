package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class Notice {

  private long nId;
  private String nTitle;
  private String nSro;
  private java.sql.Timestamp nDate;


}
