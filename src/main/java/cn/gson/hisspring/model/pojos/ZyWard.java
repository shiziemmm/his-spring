package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.List;

/**
 * 病房实体类
 */
@Data//get  set方法
public class ZyWard {

  private long wdId;//病房编号
  private String wdName;//病房名称
  private long ksId;//科室编号
  private long sId;//员工编号

  //关系
  @TableField(exist = false)//这个注解表示该字段不是此表里面的字段
  private List<ZyBed> listBed;//病床集合

  @TableField(exist = false)//这个注解表示该字段不是此表里面的字段
  private Staff staff;//员工对象



}
