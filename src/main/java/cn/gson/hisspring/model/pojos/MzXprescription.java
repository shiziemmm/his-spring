package cn.gson.hisspring.model.pojos;

import lombok.Data;
/**
 *  西药处方表
 */
@Data
public class MzXprescription {

  private long rdNumber;
  private String rdName;
  private long rdCount;
  private String rdDosage;
  private String rdFrequency;
  private String rdWay;
  private double rdPrice;
  private String rdTyppe;
  private long rdSkin;
  private String rdSkinResult;
  private String rdGrouping;
  private String rdEntrust;
    private String rdNotes;
  private long drugId;
  private long recipeNumber;


}
