package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YKStorageMapper;
import cn.gson.hisspring.model.pojos.YkStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YkStorageService {
    @Autowired
    YKStorageMapper yksorg;

    //查询全部的出入库记录
    public List<YkStorage> allStorage() {
        return yksorg.allStorage();
    }

}
