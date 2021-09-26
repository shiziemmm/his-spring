package cn.gson.hisspring.model.pojos;

import lombok.Data;

//调拨申请详表

@Data//get  set方法
public class YkAllotdetail {

  private String ykAllotdetailId;//调拨编号
  private long ykAllotId;//连接 调拨申请表
  private long ykAllotdetailIs;//1是未执行的申请 2是执行成功  3是已取消  状态
  private long ykAllotdetailCount;//调拨的数量
  private long ykDrvenId;//连接药库库存表
  private String ykDrvenDrugName;//药品名称

  private YkDruginventory ykDruginventory;//药库库存表
}
