package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.*;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.OneToMany;
import lombok.Data;
import org.apache.ibatis.annotations.Results;

import javax.xml.ws.BindingType;
import java.util.List;

/**
 * 病房实体类
 */
@Data//get  set方法
public class ZyWard{

  @TableId(value = "wd_id",type = IdType.AUTO)
  private long wdId;//病房编号

//  @TableField(updateStrategy = FieldStrategy.NOT_NULL)
  private String wdName;//病房名称

//  @TableField(updateStrategy = FieldStrategy.NOT_NULL)
  private Long ksId;//科室编号

//  @TableField(updateStrategy = FieldStrategy.NOT_NULL)
  private Long sId;//员工编号

  //关系
  @TableField(exist = false)
  @OneToMany
  @JoinColumn(name="wd_id",referencedColumnName = "wd_id")
  @Lazy(true)
  private List<ZyBed> listBed;//病床集合

  @TableField(exist = false)
  private Staff staff;//员工对象

  @TableField(exist = false)
  private String ksName;//科室名称




}
