package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.FrequencyCategoryMapper;
import cn.gson.hisspring.model.pojos.FrequencyCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrequencyCategoryService {
    @Autowired
    FrequencyCategoryMapper fre;

    public List<FrequencyCategory> dome() {
        return fre.selectList(null);
    }
}
