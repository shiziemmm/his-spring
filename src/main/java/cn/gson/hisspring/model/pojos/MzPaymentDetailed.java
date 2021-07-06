package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzPaymentDetailed {

  private long pdNumber;
  private long pmNumber;
  private String recipeNumber;
  private double labNumber;


}
