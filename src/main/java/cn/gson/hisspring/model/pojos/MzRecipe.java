package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 处方表
 */

@Data//get  set方法
public class MzRecipe {
  @TableId(type = IdType.AUTO)
  private long recipeNumber;
  @TableField(fill = FieldFill.INSERT)//丢到处理器handler中新增去
  private Date recipeTime;
  private String recipeSickName;
  private String recipeDoctorName;
  private String recipeDoctorText;
  private String sickNumber;
  private long sId;
  private long mrNumber;
  private long recipeStatePrice;

  @TableField(exist = false)//不是数据库对象
  private List<MzXprescription> xpList;//西药处方对象
  @TableField(exist = false)//不是数据库对象
  private List<MzZprescription> zpList;//中药处方对象

}
