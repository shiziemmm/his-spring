package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 手术单表
 */
@Data
public class MzSurgeryStamp {
  @TableId(type = IdType.AUTO)
  private long susNumber;
  private String susText;
  private Double susSum;
  private Integer susState;
  @TableField( fill = FieldFill.INSERT)//mybatis-plus 处理器中调用新增就自动赋值当前系统时间
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
  private Date susTime;
  private String sickNumber;
  private long sId;
  private long mrNumber;


  public void setsId(long sId) {
    this.sId = sId;
  }
  public long getsId() {
    return sId;
  }

  @TableField(exist = false)/*个人信息*/
  private MzSick sickObject;
  @TableField(exist = false)/*手术详情信息*/
  private List<MzCenterSurgery> centerSurgeryList;
}
