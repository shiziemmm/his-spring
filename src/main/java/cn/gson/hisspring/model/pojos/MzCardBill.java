package cn.gson.hisspring.model.pojos;


import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
/**
 * 诊疗卡账单表-pojos
 */

@Data
public class MzCardBill {
  @TableId(type = IdType.AUTO)
  private long cbNumber;

  @TableField(fill = FieldFill.INSERT)//处理器新增
  private Date cbTime;
  private String cbCause;
  private double cbPrice;
  private long sId;
  private long mcNumber;

  private Staff staff;

}
