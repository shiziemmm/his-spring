package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.ConsumableMapper;
import cn.gson.hisspring.model.pojos.HcIndConsumables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumableService {
    @Autowired
    ConsumableMapper consumableMapper;

    //查询耗材
    public List<HcIndConsumables> allConsumables(){
        return consumableMapper.allConsumables();
    }
    //新增耗材
    public void addConsumables(HcIndConsumables hcIndConsumables){
        consumableMapper.addConsumables(hcIndConsumables);
    }
    //修改耗材
    public void updateConsumables(HcIndConsumables hcIndConsumables){
        consumableMapper.updateConsumables(hcIndConsumables);
    }
}

