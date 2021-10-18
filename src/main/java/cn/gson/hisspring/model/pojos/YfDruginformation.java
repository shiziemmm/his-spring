package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

//药房药品信息表

@Data//get  set方法
public class YfDruginformation {

  @TableId(type = IdType.AUTO)
  @TableField(value = "drug_id")
  private int drugId;

  private String drugName;
  private int drugBarcode;
  private Double drugPrice;
  private String drugUsage;//用法
  private Long ykSpecId;
  private Long ykSupplierId;
  private Long yfDrcaId;
  private String drugUpper;
  private String drugRemark;//药品功效
  private String drugUnit;
  private String drugSpecification;
  private String drugPastdate;//保质期
  private Double drugParticle;//单粒价格
  private String drugQuantity;//每瓶数量
  private Long drugPrescription;//处方药

  @TableField(exist = false)
  private YkDrugspecifcations ykDrugspecifcations;//规格表
  @TableField(exist = false)
  private YkSupplier ykSupplier;//供应商表
  @TableField(exist = false)
  private YfDrugcategory yfDrugcategory;//类别表

  public String getDrugPastdate() {
    return drugPastdate;
  }

  public void setDrugPastdate(String drugPastdate) {
    this.drugPastdate = drugPastdate;
  }

  public int getDrugBarcode() {
    return drugBarcode;
  }

  public void setDrugBarcode(int drugBarcode) {
    this.drugBarcode = drugBarcode;
  }

  public Double getDrugParticle() {
    return drugParticle;
  }

  public void setDrugParticle(Double drugParticle) {
    this.drugParticle = drugParticle;
  }
 
  public String getDrugQuantity() {
    return drugQuantity;
  }

  public void setDrugQuantity(String drugQuantity) {
    this.drugQuantity = drugQuantity;
  }

  public Long getDrugPrescription() {
    return drugPrescription;
  }

  public void setDrugPrescription(Long drugPrescription) {
    this.drugPrescription = drugPrescription;
  }

  public int getDrugId() {
    return drugId;
  }

  public void setDrugId(int drugId) {
    this.drugId = drugId;
  }

  public String getDrugName() {
    return drugName;
  }

  public void setDrugName(String drugName) {
    this.drugName = drugName;
  }



  public Double getDrugPrice() {
    return drugPrice;
  }

  public void setDrugPrice(Double drugPrice) {
    this.drugPrice = drugPrice;
  }

  public String getDrugUsage() {
    return drugUsage;
  }

  public void setDrugUsage(String drugUsage) {
    this.drugUsage = drugUsage;
  }

  public Long getYkSpecId() {
    return ykSpecId;
  }

  public void setYkSpecId(Long ykSpecId) {
    this.ykSpecId = ykSpecId;
  }

  public Long getYkSupplierId() {
    return ykSupplierId;
  }

  public void setYkSupplierId(Long ykSupplierId) {
    this.ykSupplierId = ykSupplierId;
  }

  public Long getYfDrcaId() {
    return yfDrcaId;
  }

  public void setYfDrcaId(Long yfDrcaId) {
    this.yfDrcaId = yfDrcaId;
  }

  public String getDrugUpper() {
    return drugUpper;
  }

  public void setDrugUpper(String drugUpper) {
    this.drugUpper = drugUpper;
  }

  public String getDrugRemark() {
    return drugRemark;
  }

  public void setDrugRemark(String drugRemark) {
    this.drugRemark = drugRemark;
  }

  public String getDrugUnit() {
    return drugUnit;
  }

  public void setDrugUnit(String drugUnit) {
    this.drugUnit = drugUnit;
  }

  public String getDrugSpecification() {
    return drugSpecification;
  }

  public void setDrugSpecification(String drugSpecification) {
    this.drugSpecification = drugSpecification;
  }


  public YkDrugspecifcations getYkDrugspecifcations() {
    return ykDrugspecifcations;
  }

  public void setYkDrugspecifcations(YkDrugspecifcations ykDrugspecifcations) {
    this.ykDrugspecifcations = ykDrugspecifcations;
  }

  public YkSupplier getYkSupplier() {
    return ykSupplier;
  }

  public void setYkSupplier(YkSupplier ykSupplier) {
    this.ykSupplier = ykSupplier;
  }

  public YfDrugcategory getYfDrugcategory() {
    return yfDrugcategory;
  }

  public void setYfDrugcategory(YfDrugcategory yfDrugcategory) {
    this.yfDrugcategory = yfDrugcategory;
  }
}
