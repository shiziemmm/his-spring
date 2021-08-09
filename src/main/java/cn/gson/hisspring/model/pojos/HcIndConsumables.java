package cn.gson.hisspring.model.pojos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.sql.Timestamp;
import java.util.Date;

//耗材表

@Data//get  set方法
public class HcIndConsumables {

  private Integer consumablesId;
  private String consumablesName;//耗材名称
  private long consumablesPhy;//耗材数量
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Timestamp consumablesPurchase;//保质期
  private String consumablesUnit;//耗材规格
  private Double consumablesPrice;//耗材价格

  public Integer getConsumablesId() {
    return consumablesId;
  }

  public void setConsumablesId(Integer consumablesId) {
    this.consumablesId = consumablesId;
  }

  public String getConsumablesName() {
    return consumablesName;
  }

  public void setConsumablesName(String consumablesName) {
    this.consumablesName = consumablesName;
  }

  public long getConsumablesPhy() {
    return consumablesPhy;
  }

  public void setConsumablesPhy(long consumablesPhy) {
    this.consumablesPhy = consumablesPhy;
  }

  public Timestamp getConsumablesPurchase() {
    return consumablesPurchase;
  }

  public void setConsumablesPurchase(Timestamp consumablesPurchase) {
    this.consumablesPurchase = consumablesPurchase;
  }

  public String getConsumables_unit() {
    return consumablesUnit;
  }

  public void setConsumables_unit(String consumables_unit) {
    consumables_unit = consumables_unit;
  }

  public Double getConsumables_price() {
    return consumablesPrice;
  }

  public void setConsumables_price(Double consumables_price) {
    consumables_price = consumables_price;
  }

  @Override
  public String toString() {
    return "HcIndConsumables{" +
            "consumablesId=" + consumablesId +
            ", consumablesName='" + consumablesName + '\'' +
            ", consumablesPhy=" + consumablesPhy +
            ", consumablesPurchase='" + consumablesPurchase + '\'' +
            ", Consumables_unit='" + consumablesUnit + '\'' +
            ", Consumables_price=" + consumablesPrice +
            '}';
  }
}
