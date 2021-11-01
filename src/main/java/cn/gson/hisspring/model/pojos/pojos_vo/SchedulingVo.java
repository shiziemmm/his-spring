package cn.gson.hisspring.model.pojos.pojos_vo;

import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.pojos.Staff;
import lombok.Data;

import java.util.List;

@Data
public class SchedulingVo {
    private long tId;
    private String tName;
    private long sId;
    private String sName;
    //接收员工集合
    private List<SchedulingVo> staff;
}
