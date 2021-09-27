package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@Data//get  set方法
public class TjManResult {

  private long manResultId;
  private long checkId;
  private String manResult;
  private long manId;
  private long sId;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp manDate;
  @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp manTime;
  @TableField(exist = false)
  private TjCodeMan man;
  @TableField(exist = false)
  private TjCodeProject pro;
  @TableField(exist = false)
  private Staff staff;
}
