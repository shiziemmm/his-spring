package cn.gson.hisspring.model.pojos;

import lombok.Data;

//供应商表
@Data

public class YkSupplier {

  private long supplierId;
  private String supplierName;
  private String supplierSite;
  private String supplierPhone;
  private String supplierLinkman;

  public long getSupplierId() {
    return supplierId;
  }

  public String getSupplierName() {
    return supplierName;
  }

  public String getSupplierSite() {
    return supplierSite;
  }

  public String getSupplierPhone() {
    return supplierPhone;
  }

  public String getSupplierLinkman() {
    return supplierLinkman;
  }

  public void setSupplierId(long supplierId) {
    this.supplierId = supplierId;
  }

  public void setSupplierName(String supplierName) {
    this.supplierName = supplierName;
  }

  public void setSupplierSite(String supplierSite) {
    this.supplierSite = supplierSite;
  }

  public void setSupplierPhone(String supplierPhone) {
    this.supplierPhone = supplierPhone;
  }

  public void setSupplierLinkman(String supplierLinkman) {
    this.supplierLinkman = supplierLinkman;
  }
}
