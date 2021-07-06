package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzRecipe {

  private long recipeNumber;
  private java.sql.Timestamp recipeTime;
  private String recipeSickName;
  private String recipeDoctorName;
  private String recipeDoctorText;
  private String sickNumber;
  private long sId;
  private long mrNumber;
  private long recipeStatePrice;
  private String recipeDrugType;


}
