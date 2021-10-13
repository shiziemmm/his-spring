package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YkStorageDetailMapper;
import cn.gson.hisspring.model.pojos.YkStorageDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YkStorageDetailService {
    @Autowired
    YkStorageDetailMapper demap;

    public List<YkStorageDetail> allstoragedetail(){
        return demap.allstoragedetail();
    }
}
