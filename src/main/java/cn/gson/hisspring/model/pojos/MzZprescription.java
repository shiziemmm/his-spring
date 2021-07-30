package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 *  中药处方表
 */
@Data
public class MzZprescription {
  @TableId(type = IdType.AUTO)
  private long zpNumber;
  private String zpName;
  private String zpSpecification;
  private long zpCount;
  private String zpUsage;
  private double zpPrice;
  private String zpEntrust;
  private String zpNotes;
  private long drugId;
  private long recipeNumber;


}
