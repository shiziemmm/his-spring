package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 病人转科记录实体类
 */
@Data
public class ZyChangeDeptRecord {


  @TableId("cdr_id")
  private long cdrId;


  private String cdrCause;
  private Long ptNo;
  private Long cdrBeforeKs;
  private Long cdrAfterKs;
  private Long cdrDoctorIs;
  private java.sql.Timestamp cdrDate;
  private Long sId;//操作员

  //关系字段
  @TableField(exist = false)
  private Long bdId;//病床编号

  @TableField(exist = false)
  private Long doctorId;//主治医生


}
