package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YFDruglnventoryMapper;
import cn.gson.hisspring.model.pojos.YfDruginventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YfDruglnventoryService {
    @Autowired
    YFDruglnventoryMapper yfDruglnventoryMapper;

    /*查询药品药房库存*/
    public List<YfDruginventory> allYFlnventory() {
        return yfDruglnventoryMapper.allYFlnventory();
    }
}
