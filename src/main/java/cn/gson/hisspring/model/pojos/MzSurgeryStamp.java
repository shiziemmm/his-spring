package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 门诊手术表
 */

@Data//get  set方法
public class MzSurgeryStamp {
  @TableId(type = IdType.AUTO)
  private long susNumber;
  private String susText;
  private Date susTime;
  private String sickNumber;
  private long sId;
  private long mrNumber;


}
