package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
/**
 * 就诊记录详情表
 */
@Data//get  set方法
public class MzMedicalDetails {
  @TableId(type = IdType.AUTO)
  private long mdNumber;
  private long lwsNumber;
  private long recipeNumber;
  private String mrNumber;


}
