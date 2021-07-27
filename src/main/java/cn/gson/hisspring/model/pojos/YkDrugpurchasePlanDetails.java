package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

//药品采购计划详单

@Data//get  set方法
public class YkDrugpurchasePlanDetails {

  @TableId("yk_chase_id")
  private long ykChaseId;
  private Long drugId;
  private String ykPurchaseId;
  private String ykDrugName;
  private Long ykChaseCount;
  private Double DrugPrice;/*药品价格*/

  private YfDruginformation yfDruginformation;
}
