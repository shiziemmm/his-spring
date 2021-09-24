package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 缴费记录实体类
 */
@Data//get  set方法
public class ZyPay {

  @TableId("py_id")
  private long pyId;
  private Double pyPrice;

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp pyDate;
  private Long ptNo;
  private Long sId;


  @TableField(exist = false)
  private ZyPatientBase patientBase;//住院登记信息

  @TableField(exist = false)
  private Staff staff;//操作员  员工对象


  public ZyPay() {
  }

  public ZyPay(Double pyPrice, Timestamp pyDate, Long ptNo, Long sId) {
    this.pyPrice = pyPrice;
    this.pyDate = pyDate;
    this.ptNo = ptNo;
    this.sId = sId;
  }
}
