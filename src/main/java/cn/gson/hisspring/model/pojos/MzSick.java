package cn.gson.hisspring.model.pojos;

import lombok.Data;
/**
 * 门诊-病人资资料表
 */

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
