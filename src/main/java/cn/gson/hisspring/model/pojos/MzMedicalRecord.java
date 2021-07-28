package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 就诊记录表
 */

@Data//get  set方法
public class MzMedicalRecord {
  @TableId(type = IdType.AUTO)
  private long mrNumber;
  private String mrDoctorName;
  private String mrDiagnoseRecord;
  private java.sql.Timestamp mrSection;
  private String mrKsName;
  private String mrPhone;
  private long sId;
  private String sickNumber;
  private String mcNumberCard;


}
