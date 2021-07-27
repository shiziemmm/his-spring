package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 *  西药处方-pojos
 */


@Data//get  set方法
public class MzXprescription {
  @TableId(type = IdType.AUTO)
  private long rdNumber;
  private long rdCount;
  private String rdDosage;
  private String rdFrequency;
  private String rdWay;
  private double rdPrice;
  private String rdTyppe;
  private long rdSkin;
  private String rdSkinResult;
  private String rdGrouping;
  private long drugId;
  private long recipeNumber;


}
