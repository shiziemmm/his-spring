package cn.gson.hisspring.model.pojos;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class TjCodeMan {
  @TableId(value = "man_id",type = IdType.AUTO)
  private Long manId;
  private String manName;
  private String manSid;
  private String manGender;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp manTime;
  @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private java.sql.Timestamp manBirthtime;
  private Long manAge;
  private String manPhone;
  private Double manPhy;
  private Long manState;

  private Integer manMzZyIs;//1是门诊2是住院
  private String manMzZyId;//门诊或者住院编号

  @TableField(exist = false)
  private List<Integer> jcXm;

  @TableField(exist = false)
  private Double mcBalance;

  @TableField(exist = false)
  private List<TjManResult> tjManResultList;
}
