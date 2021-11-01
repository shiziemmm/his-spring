package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 门诊缴费表
 */
@Data
public class MzPayment {
    @TableId(type = IdType.AUTO)
    private long pmNumber;
    private String pmNumberCount;

    @TableField(fill = FieldFill.INSERT)//丢到处理器handler中新增去
    private Date pmTime;

    private String pmCard;
    private double pmSum;
    private String pmType;
    private long pmTypeId;
    private long sId;
    private long sickNumber;
    private String pmSname;
    private String pmPayment;
    private String pmMrCount;

}
