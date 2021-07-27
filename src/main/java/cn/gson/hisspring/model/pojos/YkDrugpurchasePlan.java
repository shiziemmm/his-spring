package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;
import java.util.List;

//药品采购计划表

@Data//get  set方法
public class YkDrugpurchasePlan {

  private String ykPurchaseId;
  private String ykPurchaseName;
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Timestamp ykPurchaseTime;
  private Long sId;
  private String ykPurchaseSName;
  private Long ykPurchaseIs;

  @TableField(exist = false)
  private Staff staff;/*员工表*/

  @TableField(exist = false)
  private List<YkDrugpurchasePlanDetails> ykDrugpurchasePlanDetails;/*采购计划详单*/

  @TableField(exist = false)
  private YfDruginformation yfDruginformation;/*药品信息表*/

  @Override
  public String toString() {
    return "YkDrugpurchasePlan{" +
            "ykPurchaseId='" + ykPurchaseId + '\'' +
            ", ykPurchaseName='" + ykPurchaseName + '\'' +
            ", ykPurchaseTime=" + ykPurchaseTime +
            ", sId=" + sId +
            ", ykPurchaseSName='" + ykPurchaseSName + '\'' +
            ", ykPurchaseIs=" + ykPurchaseIs +
            ", staff=" + staff +
            ", ykDrugpurchasePlanDetails=" + ykDrugpurchasePlanDetails +
            ", yfDruginformation=" + yfDruginformation +
            '}';
  }
}
