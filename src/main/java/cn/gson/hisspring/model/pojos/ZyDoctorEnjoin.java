package cn.gson.hisspring.model.pojos;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;


/**
 * 医嘱表
 */
@Data
public class ZyDoctorEnjoin {

  @TableId(value = "de_id",type = IdType.AUTO)
  private long deId;

  private Long deLongorshort;
  private Long ptNo;
  private Long sId;
  private String deDoctorName;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp deDate;
  private String deChineseMethod;
  private String deText;//嘱托
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp deExecuteDate;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp deEndDate;

  //关系
  @TableField(exist = false)
  private List<ZyDoctorEnjoinDetails> dedList;//医嘱详情集合

}
