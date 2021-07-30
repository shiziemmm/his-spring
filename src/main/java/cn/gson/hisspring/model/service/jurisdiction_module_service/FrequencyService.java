package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.FrequencyMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingMapper;
import cn.gson.hisspring.model.pojos.Frequency;
import cn.gson.hisspring.model.pojos.Scheduling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrequencyService {
    @Autowired
    FrequencyMapper frequencyMapper;

    public List<Frequency> selectAll(){
        return frequencyMapper.selectList(null);
    }
    public int addFre(Frequency frequency){return frequencyMapper.insert(frequency);}
    //修改班次信息
    public int editFre(Frequency frequency){return frequencyMapper.updateById(frequency);}
    //删除班次
    public int deletFre(long fid){return frequencyMapper.updateById(fid);}
    public List<Frequency> selectById(long fid){
        return frequencyMapper.selectById(fid);
    }


}
