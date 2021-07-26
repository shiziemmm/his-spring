package cn.gson.hisspring.model.pojos;

import lombok.Data;

/**
 * 耗材表
 */

@Data
public class HcIndConsumables {

  private long consumablesId;
  private String consumablesName;
  private long consumablesPhy;
  private double consumablesPrice;
  private java.sql.Timestamp consumablesPurchase;


}
