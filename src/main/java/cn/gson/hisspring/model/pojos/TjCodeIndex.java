package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data//get  set方法
public class TjCodeIndex {
  @TableId(value = "index_id",type = IdType.AUTO)
  private long indexId;
  private String indexName;
  private String indexSignificance;


}
