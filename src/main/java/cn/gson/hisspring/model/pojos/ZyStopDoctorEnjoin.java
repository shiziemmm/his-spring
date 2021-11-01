package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 医嘱停用记录表
 */

@Data
public class ZyStopDoctorEnjoin {

    @TableId(value = "sde_id", type = IdType.AUTO)
    private long sdeId;
    private Long derId;
    private Long sId;
    private String sdeDoctorName;
    private String sdeStopCause;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")//将数据库的类型返回成指定类型
    private java.sql.Timestamp sdeDate;
    private Long ptNo;

    //关系
    @TableField(exist = false)
    private String stopIs;//1是停详单2是停用整单医嘱

}
