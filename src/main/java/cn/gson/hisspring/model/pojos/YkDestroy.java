package cn.gson.hisspring.model.pojos;

import lombok.Data;

//销毁申请表

@Data//get  set方法
public class YkDestroy {

  private long ykDestId;
  private java.sql.Timestamp ykDestTime;
  private String ykDestCause;
  private String ykDestName;
  private long sId;
  private long ykDrvenId;

  private Staff staff;//员工对象


}
