package cn.gson.hisspring.model.pojos.pojos_vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 *病人费用明细查询
 */
@Data
@TableName(value = "seltPatientCostBreakdown")
public class PatientCostVo {
    @TableId(value = "pcd_id")
    private Long pcdId;//医嘱编号  床位费用编号
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Timestamp pcdDate;//扣费日期
    private Double pcdPrice;//扣除金额
    private Long ptNo;//住院号
    private String pcdCause;//扣除名称

}
