package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * 门诊-诊疗卡pojos
 */

@Data//get  set方法
public class MzMedicalCard {
    @TableId(type = IdType.AUTO)
    private Long mcNumber;
    private Long mcCard;
    private String mcPawd;
    private double mcBalance;
    private long mcSate;
    private long sickNumber;
    private String mcIdCard;

    @TableField(fill = FieldFill.INSERT) // 注解到 handler 处理器里进行时间的新增方便后期诊疗卡密码的修改
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE) // 注解到 handler 处理器里进行时间的新增方便后期诊疗卡密码的修改
    private Date updateTime;

    @TableField(exist = false)//不是数据库对象
    private MzSick mzSick;//诊疗卡对应的病人资料

}
