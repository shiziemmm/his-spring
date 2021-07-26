package cn.gson.hisspring.model.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 医嘱详表
 */
@Data
public class ZyDoctorEnjoinDetails {

  private long desId;
  private Long deId;
  private Long desDrugId;//药品编号
  private Long desDrugIs;
  private String desDrugName;
  private String desText;
  private String desSpecification;
  private String desMeasure;
  private Long desFrequency;
  private String desUnit;
  private String desUsage;
  private Long desCount;
  private Double desPrice;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp desEnteringDate;//录入时间
  private Long desIs;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp desPresentDate;

}
