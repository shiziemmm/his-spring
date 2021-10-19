package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.SchedulingVoMapper;
import cn.gson.hisspring.model.pojos.pojos_vo.SchedulingVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchedulingVoService {
    @Autowired
    SchedulingVoMapper sv;
    public List<SchedulingVo> list(Long ksId){
        return sv.chuaxun(ksId);
    }
}
