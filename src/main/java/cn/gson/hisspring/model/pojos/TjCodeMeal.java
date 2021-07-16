package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
//体检套餐表
@Data//get  set方法
public class TjCodeMeal {
  @TableId(value = "code_id",type = IdType.AUTO)
  private long codeId;
  private String codeName;
  private double codePay;
  private String codeType;
  @TableField(exist = false)
  private String checkIndex;
}
