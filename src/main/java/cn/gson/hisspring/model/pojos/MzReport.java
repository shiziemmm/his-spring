package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.FieldStrategy;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.lettuce.core.dynamic.annotation.CommandNaming;
import lombok.Data;

/**
 * 门诊-诊疗卡挂失记录表pojos
 */

@Data//get  set方法
public class MzReport {
    @TableId(type = IdType.AUTO)
    private long reportNumber;
    private String reportCard;
    private String reportTime;
    private long sId;
    private long sickNumber;
    private String reportCause;
    @TableField(insertStrategy = FieldStrategy.IGNORED) //允许新增时为null
    private long mcNumber;
    @TableField(insertStrategy = FieldStrategy.IGNORED) //允许新增时为null
    private Double reportPrice;

}
