package cn.gson.hisspring.model.pojos;

import lombok.Data;

//仓库表
@Data//get  set方法
public class YkWarehouse {

  private long ykWareId;
  private String ykWareName;
  private String ykWareType;

}
