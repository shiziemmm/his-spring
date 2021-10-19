package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.sql.Timestamp;

//出入库详表

@Data//get  set方法
public class YkStorageDetail {

  @TableField(value = "yk_Storage_Detail_Id")
  private long ykStorageDetailId;//药品入库编号
  private long drugId;//外连接 连接药品编号
  private long ykStorageId;//连接出入库表编号
  private String ykStorageDrugName;//药品名称
  private long ykStorageDetailCount;//药品数量
  private double ykStorageDetailPrice;//药品单价
  private long ykDrvenId;//外连接 连接药库编号
  private String ykBatch;//入库批次
  private Timestamp ykCreationDate;//生产日期
  private String ykWarehouse;//入库的仓库

  @TableField(exist = false)
  private YkStorage ykStorage;
  @TableField(exist = false)
  private YfDruginformation yfDruginformation;//药品信息
}
