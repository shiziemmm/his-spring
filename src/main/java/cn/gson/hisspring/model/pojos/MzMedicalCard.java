package cn.gson.hisspring.model.pojos;

import lombok.Data;

import java.util.Date;
/**
 * 门诊-诊疗卡pojos
 */

@Data//get  set方法
public class MzMedicalCard {

  private long mcNumberCard;
  private String mcPawd;
  private double mcBalance;
  private long mcSate;
  private long sickNumber;
  private String mcIdCard;
  private Date mcTime;

}
