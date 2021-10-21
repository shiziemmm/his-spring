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
    public void putstorage(YkDruginventory ykDruginventory){
        YkDruginventory ykdrug= new YkDruginventory();
        ykdrug.setDrugId(ykdrug.getDrugId());
        ykdrug.setSupplierId(ykdrug.getSupplierId());
        ykdrug.setYkDrvenId(ykdrug.getYkDrvenId());
        ykdrug.setYkDrvenBatch(ykdrug.getYkDrvenBatch());
        ykdrug.setYkDrvenCount(ykdrug.getYkDrvenCount());
        ykdrug.setYkDrvenMftdate(ykdrug.getYkDrvenMftdate());
        ykdrug.setYkDrvenName(ykdrug.getYkDrvenName());
        ykdrug.setYkSupplierName(ykdrug.getYkSupplierName());
        ykdrug.setYkWarehouse(ykdrug.getYkWarehouse());

         drugStorageMapper.putstorage(ykDruginventory);
    }
}
