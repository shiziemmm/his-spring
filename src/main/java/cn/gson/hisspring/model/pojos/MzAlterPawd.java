package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 门诊-修改密码记录表pojos
 */

@Data//get  set方法
public class MzAlterPawd {
  @TableId(type = IdType.AUTO)
  private long apNumber;
  private String apCause;
  private Date apTime;
  private long sId;
  private long mcNumberCard;
  private long sickNumber;


}
