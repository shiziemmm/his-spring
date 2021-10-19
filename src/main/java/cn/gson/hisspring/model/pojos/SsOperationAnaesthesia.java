package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data//get  set方法
public class SsOperationAnaesthesia {

  private long anaesthesiaId;
  private String operationAnaesthesia;
  @TableField(exist = false)
  private double projectPay;


}
