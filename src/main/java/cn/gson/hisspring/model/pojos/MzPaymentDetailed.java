package cn.gson.hisspring.model.pojos;

import lombok.Data;

/**
 * 缴费记录中间表
 */
@Data
public class MzPaymentDetailed {

  private long pmNumber;
  private long recipeNumber;
  private long susNumber;
  private long labNumber;

}
