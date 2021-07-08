package cn.gson.hisspring.model.pojos;

import lombok.Data;

//发药详表

@Data//get  set方法
public class YfDispensingdetail {

  private long yfDispenId;
  private String yfDispenRemark;
  private long ykDisId;
  private String yfDispenDurgName;
  private long yfDispenDurgCount;
  private String drugId;


}
