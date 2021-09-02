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

  private String ykPurchaseId;//药品采购计划编号
  private String ykPurchaseName;//采购的计划名称
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Timestamp ykPurchaseTime;//药品计划采购日期
  private Long sId;//指定采购计划人员 连接员工编号
  private String ykPurchaseSName;//采购员名称
  private Long ykPurchaseIs;//是否已经执行过该计划  1是未执行 2是已执行

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
