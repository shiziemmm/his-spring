package cn.gson.hisspring.model.pojos;

import lombok.Data;

//供应商表

@Data//get  set方法
public class YkSupplier {

  private long supplierId;
  private String supplierName;
  private String supplierSite;
  private String supplierPhone;
  private String supplierLinkman;


}
