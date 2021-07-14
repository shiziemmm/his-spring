package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.DrugInformation_Mapper;
import cn.gson.hisspring.model.pojos.YfDruginformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YfDruginformation_Service {
    @Autowired
    DrugInformation_Mapper information_mapper;
    /*查询药品信息*/
    public List<YfDruginformation> queryById(){
        return information_mapper.queryById();
    }
}
