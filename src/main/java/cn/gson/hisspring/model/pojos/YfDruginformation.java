package cn.gson.hisspring.model.pojos;

import lombok.Data;

//药房药品信息表

@Data//get  set方法
public class YfDruginformation {

  private long drugId;
  private String drugName;
  private String drugBarCode;
  private double drugPrice;
  private String drugUsage;
  private long ykSpecId;
  private long ykSupplierId;
  private long yfDrcaId;
  private String drugUpper;
  private String drugRemark;
  private String drugUnit;
  private String drugSpecification;
  private String drugPastDate;


}
