package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 处方表
 */

@Data//get  set方法
public class MzRecipe {
  @TableId(type = IdType.AUTO)
  private long recipeNumber;
  private Date recipeTime;
  private String recipeSickName;
  private String recipeDoctorName;
  private String recipeDoctorText;
  private String sickNumber;
  private long sId;
  private long mrNumber;
  private long recipeStatePrice;
  private String recipeDrugType;


}
