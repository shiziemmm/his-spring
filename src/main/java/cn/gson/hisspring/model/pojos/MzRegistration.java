package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
/**
 * 门诊挂号表-pojos
 */

@Data//get  set方法
public class MzRegistration {
  @TableId(type = IdType.AUTO)
  private long rtNumber;
  private double rtPrice;
  private String rtType;
  private String rtClass;
  private String rtScience;
  private String rtDoctor;
  private String rtDoctorGenre;
  private long rtState;
  @TableField( fill = FieldFill.INSERT)//注解到 handler 处理器里进行时间的新增方便后期诊疗卡密码的修改
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private Date rtTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private Date rtOnsetTime;

  private String rtOverKsName;
  private long sId;
  private long sickNumber;
  private long mcNumber;

  @TableField(exist = false)//不是数据库字段--诊疗卡对象
  private MzMedicalCard cardObject;
  @TableField(exist = false)//不是数据库字段--员工对象
  private Staff staffObject;
}
