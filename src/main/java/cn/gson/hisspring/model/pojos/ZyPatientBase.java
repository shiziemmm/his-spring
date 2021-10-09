package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class ZyPatientBase {

  @TableId(value = "pt_no",type = IdType.AUTO)
  private long ptNo;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp ptInDate;
  private String ptName;
  private String ptSex;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp ptBirthDate;
  private String ptCapacityNo;
  private String ptHomeAdder;
  private Long ksId;
  private String ptDiagnoseName;
  private Long bdId;
  private String ptOutDate;
  private Long ptAge;
  private Double ptPayMoney;
  private Double ptPrice;
  private String ptIphone;
  private Long sId;//主治医生
  private Long ptIs;//是否出院


  //关系

  @TableField(exist = false)
  private ZyDoctorEnjoin zyDoctorEnjoinList;//病人医嘱信息

  @TableField(exist = false)
  private Long inId;//住院申请编号

  @TableField(exist = false)
  private String ksName;//科室名称

  @TableField(exist = false)
  private List<ZyContacts> listContacts;//联系人集合

  @TableField(exist = false)
  private Staff staff;//医生对象

  @TableField(exist = false)
  private ZyBed bed;//病床对象

  @TableField(exist = false)
  private List<ZyPay> listPay;//病人缴费记录集合

  public ZyPatientBase(long ptNo, Double ptPayMoney, Double ptPrice) {
    this.ptNo = ptNo;
    this.ptPayMoney = ptPayMoney;
    this.ptPrice = ptPrice;
  }

  public ZyPatientBase(long ptNo, Long bdId) {
    this.ptNo = ptNo;
    this.bdId = bdId;
  }

  public ZyPatientBase(long ptNo, Double ptPrice) {
    this.ptNo = ptNo;
    this.ptPrice = ptPrice;
  }

  public ZyPatientBase(long ptNo, Long bdId, Long sId,Long ksId) {
    this.ptNo = ptNo;
    this.bdId = bdId;
    this.sId = sId;
    this.ksId = ksId;
  }

  public ZyPatientBase() {
  }
}
