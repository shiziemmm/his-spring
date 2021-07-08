package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法

//出入库表

public class YkStorage {

  private long ykStorageId;
  private String ykStoragePersonnel;
  private long sId;
  private long ykStorageOutOrEnter;
  private String ykStorageCause;


}
