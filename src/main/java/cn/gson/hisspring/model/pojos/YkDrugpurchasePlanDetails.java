package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

//药品采购计划详单

@Data//get  set方法
public class YkDrugpurchasePlanDetails {

  @TableId("yk_chase_id")
  private long ykChaseId;//药品采购计划详单编号
  private Long drugId;//药品编号
  private String ykPurchaseId;//连接采购编号
  private String ykDrugName;//采购药品名称
  private Long ykChaseCount;//采购数量
  private Double DrugPrice;/*药品价格*/
  @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
  private Timestamp ykDate;//保质期
  private String ykBatch;//药品批次

  private YfDruginformation yfDruginformation;//药品信息
  private YkSupplier ykSupplier;//供应商
}
