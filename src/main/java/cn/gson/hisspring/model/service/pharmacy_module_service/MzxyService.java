package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.MzXprescriMapper;
import cn.gson.hisspring.model.pojos.MzXprescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MzxyService {
    @Autowired
    MzXprescriMapper mzxymp;

    //查询门诊西药需要发的药品
    public List<MzXprescription>allmzxy(){
        return mzxymp.allmzxy();
    }
}
