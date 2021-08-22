package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.pojos.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulingService {
    @Autowired
    SchedulingMapper schedulingMapper;

    public List<Scheduling> selectList(){
        return schedulingMapper.selectList(null);
    }
    public boolean addSch(Scheduling scheduling,List<Integer> list){
        return schedulingMapper.addSch(scheduling,list) < 0 ? false : true;
    }
    public List<Scheduling> selectAll(String star,String end){
        return schedulingMapper.selectAll(star,end);
    }
    public List<Scheduling> selectWeek(String rq,long ksId){
        return schedulingMapper.selectWeek(rq,ksId);
    }
}
