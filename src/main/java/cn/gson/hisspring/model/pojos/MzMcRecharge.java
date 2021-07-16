package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 *  门诊-充值记录表pojos
 */

@Data//get  set方法
public class MzMcRecharge {

  @TableId(type = IdType.AUTO)
  private long mcrcNumber;
  private double mcrcPrice;
  private Date mcrcTime;
  private String mcNumberCard;
  private String mcrcPayment;
  private long sId;

  @TableField(exist = false)//不是数据库对象
  private MzSick mzSick;//诊疗卡对应的病人资料
}
