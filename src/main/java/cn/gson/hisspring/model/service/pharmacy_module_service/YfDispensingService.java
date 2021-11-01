package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YfDispensingMapper;
import cn.gson.hisspring.model.pojos.YfDispensing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YfDispensingService {
    @Autowired
    YfDispensingMapper disMap;

    /**
     * 发药记录查询
     *
     * @param yfDispensing
     */
    public List<YfDispensing> allyfdisng(YfDispensing yfDispensing) {
        return disMap.allyfdisng(yfDispensing);
    }
}
