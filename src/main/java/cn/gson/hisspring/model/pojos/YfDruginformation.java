package cn.gson.hisspring.model.pojos;

import lombok.Data;

//药房药品信息表

@Data//get  set方法
public class YfDruginformation {

  private Long drugId;
  private String drugName;
  private String drugBarCode;
  private Double drugPrice;
  private String drugUsage;
  private Long ykSpecId;
  private Long ykSupplierId;
  private Long yfDrcaId;
  private String drugUpper;
  private String drugRemark;
  private String drugUnit;
  private String drugSpecification;
  private String drugPastDate;

  private YkDrugspecifcations ykDrugspecifcations;//规格表
  private YkSupplier ykSupplier;//供应商表
  private YfDrugcategory yfDrugcategory;//类别表

  public long getDrugId() {
    return drugId;
  }

  public String getDrugName() {
    return drugName;
  }

  public String getDrugBarCode() {
    return drugBarCode;
  }

  public double getDrugPrice() {
    return drugPrice;
  }

  public String getDrugUsage() {
    return drugUsage;
  }

  public Long getYkSpecId() {
    return ykSpecId;
  }

  public Long getYkSupplierId() {
    return ykSupplierId;
  }

  public Long getYfDrcaId() {
    return yfDrcaId;
  }

  public String getDrugUpper() {
    return drugUpper;
  }

  public String getDrugRemark() {
    return drugRemark;
  }

  public String getDrugUnit() {
    return drugUnit;
  }

  public String getDrugSpecification() {
    return drugSpecification;
  }

  public String getDrugPastDate() {
    return drugPastDate;
  }

  public YkDrugspecifcations getYkDrugspecifcations() {
    return ykDrugspecifcations;
  }

  public YkSupplier getYkSupplier() {
    return ykSupplier;
  }

  public YfDrugcategory getYfDrugcategory() {
    return yfDrugcategory;
  }

  public void setDrugId(long drugId) {
    this.drugId = drugId;
  }

  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }

  public void setDrugBarCode(String drugBarCode) {
    this.drugBarCode = drugBarCode;
  }

  public void setDrugPrice(double drugPrice) {
    this.drugPrice = drugPrice;
  }

  public void setDrugUsage(String drugUsage) {
    this.drugUsage = drugUsage;
  }

  public void setYkSpecId(Long ykSpecId) {
    this.ykSpecId = ykSpecId;
  }

  public void setYkSupplierId(Long ykSupplierId) {
    this.ykSupplierId = ykSupplierId;
  }

  public void setYfDrcaId(Long yfDrcaId) {
    this.yfDrcaId = yfDrcaId;
  }

  public void setDrugUpper(String drugUpper) {
    this.drugUpper = drugUpper;
  }

  public void setDrugRemark(String drugRemark) {
    this.drugRemark = drugRemark;
  }

  public void setDrugUnit(String drugUnit) {
    this.drugUnit = drugUnit;
  }

  public void setDrugSpecification(String drugSpecification) {
    this.drugSpecification = drugSpecification;
  }

  public void setDrugPastDate(String drugPastDate) {
    this.drugPastDate = drugPastDate;
  }

  public void setYkDrugspecifcations(YkDrugspecifcations ykDrugspecifcations) {
    this.ykDrugspecifcations = ykDrugspecifcations;
  }

  public void setYkSupplier(YkSupplier ykSupplier) {
    this.ykSupplier = ykSupplier;
  }

  public void setYfDrugcategory(YfDrugcategory yfDrugcategory) {
    this.yfDrugcategory = yfDrugcategory;
  }


}
