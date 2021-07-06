package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzSick {

  private long sickNumber;
  private String sickIdCard;
  private String sickName;
  private String sickPhone;
  private long sickAge;
  private String sickSex;
  private String sickSite;
  private String sickHistory;

}
