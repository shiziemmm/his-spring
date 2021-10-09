package cn.gson.hisspring.model.pojos;

import lombok.Data;

//调拨申请详表

@Data//get  set方法
public class YkAllotdetail {

  private int ykAllotdetailId;//调拨编号
  private String ykAllotId;//连接 调拨申请表
  private long ykAllotdetailIs;//1是未执行的申请 2是执行成功  3是已取消  状态
  private long ykAllotdetailCount;//调拨的数量
  private long ykDrvenId;//连接药库库存表
  private String ykDrvenDrugName;//药品名称

  private YkDruginventory ykDruginventory;//药库库存表
  private YfDruginventory yfDruginventory;//药房库存

  public int getYkAllotdetailId() {
    return ykAllotdetailId;
  }

  public void setYkAllotdetailId(int ykAllotdetailId) {
    this.ykAllotdetailId = ykAllotdetailId;
  }

  public String getYkAllotId() {
    return ykAllotId;
  }

  public void setYkAllotIds(String ykAllotId) {
    this.ykAllotId = ykAllotId;
  }

  public long getYkAllotdetailIs() {
    return ykAllotdetailIs;
  }

  public void setYkAllotdetailIs(long ykAllotdetailIs) {
    this.ykAllotdetailIs = ykAllotdetailIs;
  }

  public long getYkAllotdetailCount() {
    return ykAllotdetailCount;
  }

  public void setYkAllotdetailCount(long ykAllotdetailCount) {
    this.ykAllotdetailCount = ykAllotdetailCount;
  }

  public long getYkDrvenId() {
    return ykDrvenId;
  }

  public void setYkDrvenId(long ykDrvenId) {
    this.ykDrvenId = ykDrvenId;
  }

  public String getYkDrvenDrugName() {
    return ykDrvenDrugName;
  }

  public void setYkDrvenDrugName(String ykDrvenDrugName) {
    this.ykDrvenDrugName = ykDrvenDrugName;
  }
}
