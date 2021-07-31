package cn.gson.hisspring.model.pojos;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
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
  @TableField(fill = FieldFill.INSERT)//丢到处理器handler中新增去
  private Date mrSection;
  private String mrKsName;
  private String mrIdCard;
  private long mrState;
  private String mrSickType;
  private Double mrTotalMoney;

  private long sId;
  private String sickNumber;
  private long bnNumber;
  private String mcNumber;

  @TableField(exist = false)//不是数据库的
  private MzRecipe recipeObject;//处方表

  public long getsId() {
    return sId;
  }
  public void setsId(long sId) {
    this.sId = sId;
  }

}
