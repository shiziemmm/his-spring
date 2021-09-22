package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 *  检验项目表
 */

@Data//get  set方法
public class MzLaboratory {
  @TableId(type = IdType.AUTO)
  private long labNumber;
  private String labText;
  private long sickNumber;

  private Date labTime;
  private long sId;
  private long mrNumber;


}
