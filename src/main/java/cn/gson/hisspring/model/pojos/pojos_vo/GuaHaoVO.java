package cn.gson.hisspring.model.pojos.pojos_vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

@Data
public class GuaHaoVO {
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Date dateVue;
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="Asia/Shanghai")//将数据库的类型返回成指定类型
    private Date dateJav;
    private Long ksId;
    private String text;
    private long index;

    public Long getKsId() {
        return ksId;
    }

    public void setKsId(Long ksId) {
        this.ksId = ksId;
    }
}
