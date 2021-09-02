package cn.gson.hisspring.model.pojos;

import lombok.Data;

/**
 * 药品调拨库存记录表
 */
@Data
public class ZyDeptDrugAllot {

  private long ddaId;
  private Long ksId;
  private Long ddaSidAllot;
  private java.sql.Timestamp ddaDate;
  private Long ddaIs;
  private Double ddaMaxUnitCount;
  private Double ddaMinUnitCount;
  private String ddaDrugName;
  private Long ddaDrugId;

  //关系
  private String ksName;//科室名称
  private String sName;//员工名称

}
