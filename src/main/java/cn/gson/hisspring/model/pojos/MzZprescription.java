package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzZprescription {

  private long zpNumber;
  private long drugId;
  private String zpSpecification;
  private long zpCount;
  private String zpUsage;
  private double zpPrice;
  private long recipeNumber;


}
