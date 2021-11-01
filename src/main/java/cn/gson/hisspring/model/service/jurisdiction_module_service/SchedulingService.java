package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.pojos.Scheduling;
import cn.gson.hisspring.model.pojos.pojos_vo.ReportForm;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SchedulingService {
    @Autowired
    SchedulingMapper schedulingMapper;

    public List<Scheduling> selectList() {
        return schedulingMapper.selectList(null);
    }

    public boolean addSch(Date rq, Integer sid, List<Integer> list) {
        return schedulingMapper.addSch(rq, sid, list) < 0 ? false : true;
    }

    public List<Scheduling> selectWeek(String rq, long ksId) {
        return schedulingMapper.selectWeek(rq, ksId);
    }

    public List<Scheduling> selectAllWeek(String rq, long ksId) {
        return schedulingMapper.selectWeek(rq, ksId);
    }

    public List<Scheduling> selectNow(String rq, long ksId, long sId) {
        return schedulingMapper.selectNow(rq, ksId, sId);
    }

    public List<Scheduling> selectKsName(ReportForm reportForm) {
        return schedulingMapper.selectKsName(reportForm);
    }

    ;

}
