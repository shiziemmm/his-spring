package cn.gson.hisspring.model.pojos;

import lombok.Data;

/**
 * 医嘱停用记录表
 */

@Data
public class ZyStopDoctorEnjoin {

  private long sdeId;
  private Long derId;
  private Long sId;
  private String sdeDoctorName;
  private String sdeStopCause;
  private java.sql.Timestamp sdeDate;
  private Long ptNo;

}
