package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.DrugStorageMapper;
import cn.gson.hisspring.model.pojos.YkDruginventory;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlanDetails;
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
    public void putstorage(List<YkDrugpurchasePlanDetails> ykDrugpurchasePlanDetails ){
        System.err.println(ykDrugpurchasePlanDetails);
        for (int j = 0; j < ykDrugpurchasePlanDetails.size(); j++) {
            System.err.println(ykDrugpurchasePlanDetails.get(j).getYfDruginformation().getDrugName()+"name");
        }
        YkDruginventory ykdrug= new YkDruginventory();
        for (int i = 0; i < ykDrugpurchasePlanDetails.size(); i++) {
            System.err.println(ykDrugpurchasePlanDetails.get(i).getDrugPrice());
            ykdrug.setDrugId(ykDrugpurchasePlanDetails.get(i).getDrugId());
            ykdrug.setYkDrvenName(ykDrugpurchasePlanDetails.get(i).getYkDrugName());
            ykdrug.setYkDrvenBatch(ykDrugpurchasePlanDetails.get(i).getYkBatch());
//            ykdrug.setYkSelingprice(ykDrugpurchasePlanDetails.get(i).getDrugPrice());
            ykdrug.setYkDrvenMftdate(ykDrugpurchasePlanDetails.get(i).getYkDate());
//            ykdrug.setSupplierId(ykdrug.getSupplierId());
//            ykdrug.setYkDrvenId(ykdrug.getYkDrvenId());
//            ykdrug.setYkDrvenBatch(ykdrug.getYkDrvenBatch());
//            ykdrug.setYkDrvenCount(ykdrug.getYkDrvenCount());
//            ykdrug.setYkDrvenMftdate(ykdrug.getYkDrvenMftdate());
//            ykdrug.setYkDrvenName(ykdrug.getYkDrvenName());
//            ykdrug.setYkSupplierName(ykdrug.getYkSupplierName());
//            ykdrug.setYkWarehouse(ykdrug.getYkWarehouse());
        }
        System.err.println(ykdrug);
//        drugStorageMapper.putstorage(ykdrug);

/*

        YkDrugpurchasePlanDetails

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
*/

        // drugStorageMapper.putstorage(ykDruginventory);
    }
}
