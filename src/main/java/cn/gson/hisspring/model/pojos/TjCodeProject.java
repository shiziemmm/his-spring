package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data//get  set方法
public class TjCodeProject {
  @TableId(value = "check_id",type = IdType.AUTO)
  private long checkId;
  private String checkName;
  private double checkPay;
  private long indexId;

  @TableField(exist = false)
  private TjCodeIndex tjCodeIndex;


}
