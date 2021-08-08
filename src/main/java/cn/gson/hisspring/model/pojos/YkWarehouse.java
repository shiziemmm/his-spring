package cn.gson.hisspring.model.pojos;

import lombok.Data;

//仓库表
@Data//get  set方法
public class YkWarehouse {

  private long ykWareId;//药库编号
  private String ykWareName;//药库名称
  private String ykWareType;//药库类型

}
