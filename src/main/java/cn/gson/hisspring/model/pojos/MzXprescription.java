package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 *  西药处方表
 */
@Data
public class MzXprescription {
  @TableId(type = IdType.AUTO)
  private long rdNumber;
  private String rdName;
  private long rdCount;
  private String rdWay;
  private double rdPrice;
  private String rdTyppe;
  private Long  rdSkin;
  private String rdGrouping;
  private String rdEntrust;
  private String rdNotes;
  private long drugId;
  private long recipeNumber;


  private String rdDosage;//用量
  private String rdFrequency;//频次
  private String rdSkinResult;//皮试结果

}
