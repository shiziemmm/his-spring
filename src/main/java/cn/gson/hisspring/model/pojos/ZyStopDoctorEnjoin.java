package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyStopDoctorEnjoin {

  private long sdeId;
  private long derId;
  private long sId;
  private String sdeDoctorName;
  private String sdeStopCause;
  private long drugId;
  private String sdeDrugName;
  private long ptNo;


}
