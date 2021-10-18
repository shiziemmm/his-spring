package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

//调拨申请详表

@Data//get  set方法
public class YkAllotdetail {

  private int ykAllotdetailId;//调拨编号
  private String ykAllotId;//连接 调拨申请表
  private Long ykAllotdetailIs;//1是未执行的申请 2是执行成功  3是已取消  状态
  private Long ykAllotdetailCount;//调拨的数量
  private Long ykDrugId;//药品信息编号

  //关系
  @TableField(exist = false)
  private YkDruginventory ykDruginventory;//药库库存表
  @TableField(exist = false)
  private YfDruginventory yfDruginventory;//药房库存
  @TableField(exist = false)
  private YfDruginformation yfDruginformation;//药品信息
  @TableField(exist = false)
  private YkAllot ykAllot;//调拨申请详表

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


}
