package cn.gson.hisspring.model.pojos.pojos_vo;

import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.TjCodeMan;
import cn.gson.hisspring.model.pojos.TjCodeProject;
import cn.gson.hisspring.model.pojos.TjManResult;
import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * 化验项目查询实体类
 */
@Data
public class ResultManVo {
    private long manResultId;
    private long checkId;
    private String manResult;
    private long manId;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private java.sql.Timestamp manDate;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private java.sql.Timestamp manTime;
    private Long sId;
    private TjCodeMan man;
    private TjCodeProject pro;
    private String sName;
    private Long iss;//1是没取消的 2是已取消不能使用

    private TjCodeProject tjCodeProject;//化验项目
}
