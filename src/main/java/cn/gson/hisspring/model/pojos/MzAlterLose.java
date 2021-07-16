package cn.gson.hisspring.model.pojos;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 *  门诊-挂失补卡修改记录表pojos
 */

@Data
public class MzAlterLose {
  @TableId(type = IdType.AUTO)
  private long alNumber;
  private Long alCard;
  private Double alPrice;
  private String alCause;
  private Long mcNumber;
  private Long sId;
  private Long sickNumber;

  @TableField(fill = FieldFill.INSERT) // 注解到 handler 处理器里进行时间的新增方便后期诊疗卡密码的修改
  private Date alTime;
  @TableField(exist = false)//不是数据库对象
  private MzSick sickObject;//诊疗卡对应的病人资料
  @TableField(exist = false)//不是数据库对象
  private MzMedicalCard cardObject;//诊疗卡对象

}
