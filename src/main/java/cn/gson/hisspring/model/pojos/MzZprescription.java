package cn.gson.hisspring.model.pojos;

import lombok.Data;
/**
 *  中药处方表
 */
@Data
public class MzZprescription {

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
