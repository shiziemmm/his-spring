package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
/**
 * 排号表
 */

@Data
public class MzOpcNumber {
  @TableId(type = IdType.AUTO)
  private long bnNumber;
  private long bnState;
  private long bnCount;

  @TableField(insertStrategy =  FieldStrategy.IGNORED )
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private Date bnTime;
  private String bnIdCard;
  private String bnKsName;
  private String bnScience;
  private String bnSickName;
  private long rtNumber;
  @TableField(insertStrategy =  FieldStrategy.IGNORED )
  private String mrNumber;

  @TableField(exist = false)// 挂号记录表 -数据对象
  private MzRegistration rtRegObject;

}
