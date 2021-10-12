package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data//get  set方法

//出入库表

public class YkStorage {

  @TableField(value = "yk_Storage_id")
  private long ykStorageId;//药品入库编号

  private String ykStoragePersonnel;//药品入库负责人员姓名
  private Long sId;//外连接 连接员工表
  private Long ykStorageOutorenter;//1是入库 2是出库
  private String ykStorageCause;//出入库原因

  @TableField(exist = false)
  private Staff staff;//员工数据
}
