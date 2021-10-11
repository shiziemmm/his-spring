package cn.gson.hisspring.model.pojos;


import lombok.Data;

/**
 * 西药处方
 */

@Data
public class MzXprescription {

  private long rdNumber;
  private String rdName;
  private String rdDrugSpecification;
  private String rdSpecSpecification;
  private long rdCount;
  private double rdPrice;
  private long rdSkin;
  private String rdEntrust;
  private String rdSkinResult;

  private long rdStatePrice;
  private long drugId;
  private long recipeNumber;

}
