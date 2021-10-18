package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.MzZprescriMapper;
import cn.gson.hisspring.model.pojos.MzZprescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MzzyService {
    @Autowired
    MzZprescriMapper mzzymp;

    //查询门诊中药需要发的药品
    public List<MzZprescription> allmzzy(Long recipeNumber){
        return mzzymp.allMzzy(recipeNumber);
    }
}
