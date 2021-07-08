package cn.gson.hisspring.model.pojos;

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
  private long ksId;
  private String ptDiagnoseName;
  private String bdId;
  private String ptOutDate;
  private String ptAge;
  private String ptPayMoney;
  private String ptPrice;

}
