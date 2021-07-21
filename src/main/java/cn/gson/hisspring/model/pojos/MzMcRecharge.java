package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.util.Date;
/**
 * 充值操作记录表-pojos
 */


@Data
public class MzMcRecharge {
  @TableId(type = IdType.AUTO)//自增id
  private long mcrcNumber;
  private double mcrcPrice;
  private String mcrcPayment;
  private String mcrcState;
  private long mcNumber;
  private long sId;

  @TableField( fill = FieldFill.INSERT)
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private Date mcrcTime;
  @TableField(exist = false)//不是数据库对象
  private Staff staffObject; //员工对象
  @TableField(exist = false)//不是数据库对象
  private MzMedicalCard cardObject;//诊疗卡对象

}
