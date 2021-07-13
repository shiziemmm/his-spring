package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
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

  @TableId(value = "bd_id",type = IdType.AUTO)
  private long bdId;//病床编号

  private String bdName;//病床名称

  private Long wdId;//连接病房编号
  private Double bdPrice;//病床价格
  private Long bdIs;//是否能入住1表示可用2表示停用  3表示已有病人入住

  private Long ptNo;//连接病人编号


  //关系
  @TableField(exist = false)
  private ZyWard ward;//病房实体类

  @TableField(exist = false)
  private ZyPatientBase zyPatientBase;//住院登记实体类


  //关系字段(方便查询这样就需要一个实体类)
  @TableField(exist = false)
  private String ptName;//病人名称


  public ZyBed() {

  }

  public ZyBed(long bdId, Long bdIs) {
    this.bdId = bdId;
    this.bdIs = bdIs;
  }

  public ZyBed(long bdId, Long bdIs, Long ptNo) {
    this.bdId = bdId;
    this.bdIs = bdIs;
    this.ptNo = ptNo;
  }
}
