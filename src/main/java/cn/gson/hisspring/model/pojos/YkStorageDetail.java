package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class YkStorageDetail {

  private long ykStorageDetailId;
  private long drugId;
  private long ykStorageId;
  private String ykStorageDrugName;
  private long ykStorageDetailCount;
  private double ykStorageDetailPrice;
  private long ykDrvenId;


}
