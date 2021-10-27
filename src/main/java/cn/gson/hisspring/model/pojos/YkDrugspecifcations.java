package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

//药品规格表

@Data//get  set方法
public class YkDrugspecifcations {

  @TableId
  private long specId;
  private String specSpecification;
  private String specPack;


}
