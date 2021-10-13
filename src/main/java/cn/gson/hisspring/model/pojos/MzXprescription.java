package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 西药处方表
 */
@Data
public class MzXprescription {
  @TableId(type = IdType.AUTO)
  private long rdNumber;
  private String rdName;
  private String rdFyjl;
  private String rdDw;
  private long rdCount;
  private double rdPrice;
  private String rdEntrust;
  private long rdStatePrice;
  private long drugId;
  private long recipeNumber;



}
