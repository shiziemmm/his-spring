package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

  @TableId("wd_id")
  private long wdId;//病房编号
  private String wdName;//病房名称
  private long ksId;//科室编号
  private long sId;//员工编号

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
