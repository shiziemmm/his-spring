package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzXprescription {

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
