package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class TjCodeMeal {

  private long codeId;
  private String codeName;
  private double codePay;
  private String codeType;

}
