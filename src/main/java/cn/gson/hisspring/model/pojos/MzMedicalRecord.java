package cn.gson.hisspring.model.pojos;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
/**
 * 就诊记录表
 */
@Data
public class MzMedicalRecord {
  @TableId(type = IdType.AUTO)
  private long mrNumber;
  private String mrCount;
  private String mrDoctorName;
  private String mrDiagnoseRecord;
  private Date mrSection;
  private String mrKsName;
  private String mrPhone;
  private long mrState;
  private long sId;
  private String sickNumber;
  private long bnNumber;
  private String mcNumber;

}
