package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.github.dreamyoung.mprelation.JoinColumn;
import com.github.dreamyoung.mprelation.Lazy;
import com.github.dreamyoung.mprelation.ManyToOne;
import com.github.dreamyoung.mprelation.OneToMany;
import lombok.Data;


/**
 * 病床实体类
 */
@Data//get  set方法
public class ZyBed {

  private long bdId;//病床编号
  private String bdName;//病床名称

  @TableId(value = "wd_id")
  private long wdId;//连接病房编号
  private double bdPrice;//病床价格
  private long bdIs;//是否能入住1表示可用2表示不可用需要维修 3表示已有病人入住
  private long ptNo;//连接病人编号

  //关系
  @TableField(exist = false)
  @ManyToOne
  @Lazy(true)
  @JoinColumn(name = "wd_id", referencedColumnName = "wd_id")
  private ZyWard ward;//病房实体类

  private ZyPatientBase zyPatientBase;//住院登记实体类

  //关系字段(方便查询这样就需要一个实体类)
  private String ptName;//病人名称


}
