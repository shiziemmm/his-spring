package cn.gson.hisspring.model.pojos.pojos_vo;

import cn.gson.hisspring.model.pojos.Scheduling;
import lombok.Data;

import java.util.List;

@Data
public class WeekVo {
    private String rq;
    private String xq;
    private boolean state;//true或false
    private List<Scheduling> slist;
}
