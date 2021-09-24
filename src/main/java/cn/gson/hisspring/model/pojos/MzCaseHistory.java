package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 病历表
 */

@Data
public class MzCaseHistory {
  @TableId(type = IdType.AUTO)
  private long chNumber;
  @TableField(fill = FieldFill.INSERT_UPDATE)//丢到处理器handler中新增去
  private Date chTime;

  private String chDoctor;
  private String chComplaint;
  private String chHistory;
  private String chFamilyHistory;
  private String chOe;
  private String chOps;
  private String chCause;
  private String chDoctorText;
  private long sickNumber;
  private long mrNumber;


}
