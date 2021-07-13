package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data//get  set方法
public class ZyPatientBase {

  @TableId(value = "pt_no")
  private long ptNo;
  private java.sql.Timestamp ptInDate;
  private String ptName;
  private String ptSex;
  private java.sql.Timestamp ptBirthDate;
  private String ptCapacityNo;
  private String ptHomeAdder;
  private Long ksId;
  private String ptDiagnoseName;
  private Long bdId;
  private String ptOutDate;
  private String ptAge;
  private String ptPayMoney;
  private String ptPrice;


  //关系

  @TableField(exist = false)
  private String ksName;

  public ZyPatientBase(long ptNo, Long bdId) {
    this.ptNo = ptNo;
    this.bdId = bdId;
  }

  public ZyPatientBase() {
  }
}
