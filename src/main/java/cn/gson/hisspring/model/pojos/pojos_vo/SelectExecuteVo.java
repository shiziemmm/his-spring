package cn.gson.hisspring.model.pojos.pojos_vo;

import lombok.Data;

import javax.annotation.security.DenyAll;
import java.sql.Timestamp;
import java.util.Date;

/**
 * 已执行医嘱的多条件查询实体类
 */
@Data
public class SelectExecuteVo {

    private Date startDate;//开始日期
    private Date endDate;//结束日期
    private String searchLike;//模糊搜索
    private Long doctorType;//医嘱类型
    private Long ptNo;//住院号

}
