package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.DrugStorageMapper;
import cn.gson.hisspring.model.pojos.YkDruginventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugStorageService {
    @Autowired
    DrugStorageMapper drugStorageMapper;
    /*查询药库的药品库存*/
    public List<YkDruginventory> allDrugStorg(){
        return drugStorageMapper.allDrugStorg();
    }

    /*药品入库*/
    /*public void putstorage(YkDruginventory ykDruginventory){
        return drugStorageMapper.putstorage(ykDruginventory);
    }*/
}
