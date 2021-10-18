package cn.gson.hisspring.model.pojos.pojos_vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.annotation.security.DenyAll;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 已执行医嘱的多条件查询实体类
 */
@Data
public class SelectExecuteVo {


    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Date startDate;//开始日期
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Date endDate;//结束日期

    private String searchLike;//模糊搜索
    private Long doctorType;//医嘱类型
    private Long ptNo;//住院号
    private List<Long> sIdArr;//员工编号
    private Double startPrice;//开始金额
    private Double endPrice;//结束金额
    private List<Long> ksIdArr;//科室数组


}
