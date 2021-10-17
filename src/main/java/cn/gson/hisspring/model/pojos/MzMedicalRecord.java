package cn.gson.hisspring.model.pojos;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
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
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private Date mrSection;
  @TableField(fill = FieldFill.INSERT_UPDATE)//丢到处理器handler中新增去
  private Date  mrOverTime;
  private String mrKsName;
  private String mrIdCard;
  private long mrState;
  private String mrSickType;
  private Double mrTotalMoney;
  private String mrMcCard;
  private long sId;
  private Long sickNumber;
  private long bnNumber;
  private long mcNumber;

  @TableField(exist = false)
  private MzOpcNumber opcObject;//排号表对象

  @TableField(exist = false)//不是数据库的
  private MzRecipe recipeObject;//处方表

//  @TableField(exist = false)//不是数据库的
//  private MzSurgeryStamp surgeryStampObject; //手术表
//  @TableField(exist = false)//不是数据库的
//  private MzLaboratory laboratoryObject; //化验表

  @TableField(exist = false)//不是数据库的
  private MzCaseHistory historyObject;//病历表
  @TableField(exist = false)//不是数据库的
  private MzSick sickObject;//病人资料表








  public long getsId() {
    return sId;
  }
  public void setsId(long sId) {
    this.sId = sId;
  }

}
