package cn.gson.hisspring.model.pojos;

import lombok.Data;

//调拨申请详表

@Data//get  set方法
public class YkAllotdetail {

  private long ykAllotdetailId;
  private long ykAllotId;
  private long ykAllotdetailIs;
  private long ykAllotdetailCount;
  private long ykDrvenId;
  private String ykDrvenDrugName;

}
