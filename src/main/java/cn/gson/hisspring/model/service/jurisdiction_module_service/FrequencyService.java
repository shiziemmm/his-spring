package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.FrequencyMapper;
import cn.gson.hisspring.model.pojos.Frequency;
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
}
