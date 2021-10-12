package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data//get  set方法

//出入库表

public class YkStorage {

  @TableField(value = "yk_Storage_id")
  private long ykStorageId;

  private String ykStoragePersonnel;
  private Long sId;
  private Long ykStorageOutorenter;
  private String ykStorageCause;


}
