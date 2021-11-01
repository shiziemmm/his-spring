package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 医嘱详表
 */
@Data
public class ZyDoctorEnjoinDetails {

    @TableId(value = "des_id", type = IdType.AUTO)
    private long desId;//医嘱详细编号
    private Long deId;//连接医嘱编号
    private Long desDrugId;//连接药品编号或者耗材
    private Long desDrugIs;//是药品还是耗材 1是药品 2是耗材 3处方药
    private String desDrugName;//药品名称
    private String desText;//医嘱内容
    private String desSpecification;//规格
    private String desMeasure;//计量
    private Long desFrequency;//频率(一天多少次)
    private String desUnit;//单位
    private String desUsage;//用法
    private Long desCount;//今天一天的用量
    private Double desPrice;//价格
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp desExecuteDate;//执行时间
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp desEndDate;//结束时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")//将数据库的类型返回成指定类型
    private java.sql.Timestamp desEnteringDate;//详表录入时间
    private Long desIs;//是否停止执行医嘱 1是未停止 2是已停用
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Shanghai")//将数据库的类型返回成指定类型
    private java.sql.Timestamp desPresentDate;//最新执行时间


    //关系
    @TableField(exist = false)
    private Long deLongorshort;//是否是长嘱或者临时医嘱
    @TableField(exist = false)
    private Long ptNo;//住院号
    @TableField(exist = false)
    private Long sId;//开医嘱医生编号
    @TableField(exist = false)
    private String deDoctorName;//开嘱医生名称

    public ZyDoctorEnjoinDetails(long desId, Timestamp desEndDate) {
        this.desId = desId;
        this.desEndDate = desEndDate;
    }

    public ZyDoctorEnjoinDetails() {
    }
}
