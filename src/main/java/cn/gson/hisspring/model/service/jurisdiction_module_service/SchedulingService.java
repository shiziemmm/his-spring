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
}
