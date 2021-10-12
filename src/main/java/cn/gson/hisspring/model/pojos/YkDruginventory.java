package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
//import sun.rmi.runtime.Log;

import java.sql.Timestamp;

//药品药库库存表

@Data//get  set方法
@TableName(value = "yk_druginventory")
public class YkDruginventory {

  @TableId
  @TableField(value = "yk_Drven_Id")
  private long ykDrvenId;//药品库存编号

  private Long drugId;//药品编号
  private String ykDrvenName;//药品名称
  private Long ykWareId;//仓库编号
  private String ykDrvenBatch;//药品批次
  private Long ykDrvenCount;//药品库存 药品数量
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Timestamp ykDrvenMftdate;//生产日期
  private Long supplierId;//供应商编号
  private String ykSupplierName;//供应商名称
  private Double ykSellingprice;//药品售价

  public YkDruginventory(long ykDrvenId, Long ykDrvenCount) {
    this.ykDrvenId = ykDrvenId;
    this.ykDrvenCount = ykDrvenCount;
  }

  public YkDruginventory() {
  }

  @TableField(exist = false)
  private YkWarehouse ykWarehouse;//仓库
  @TableField(exist = false)
  private YkSupplier ykSupplier;//供应商
}
