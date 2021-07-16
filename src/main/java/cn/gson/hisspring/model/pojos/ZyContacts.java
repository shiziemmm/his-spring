package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 病人关系实体类
 */
@Data
public class ZyContacts {

  @TableId("cts_id")
  private long ctsId;


  private String ctsName;
  private String ctsIphone;
  private String ctsRelation;
  private Long ptNo;



}
