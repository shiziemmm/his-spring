package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.DrugStorageMapper;
import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YkDrugpurchasePlanMapper;
import cn.gson.hisspring.model.pojos.YkDruginventory;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlan;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlanDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugStorageService {
    @Autowired
    DrugStorageMapper drugStorageMapper;

    @Autowired
    YkDrugpurchasePlanMapper ydpm;

    /*查询药库的药品库存*/
    public List<YkDruginventory> allDrugStorg(){
        return drugStorageMapper.allDrugStorg();
    }

    /**
     * 药品入库
     * @param ykDrugpurchasePlanDetails 药品入库详情集合
     * @param id 入库编号
     */
    public void putstorage(List<YkDrugpurchasePlanDetails> ykDrugpurchasePlanDetails,String id){
        System.err.println(ykDrugpurchasePlanDetails);
        for (int j = 0; j < ykDrugpurchasePlanDetails.size(); j++) {
            System.err.println(ykDrugpurchasePlanDetails.get(j).getYfDruginformation().getDrugName()+"name");
        }
        for (YkDrugpurchasePlanDetails ykdpd : ykDrugpurchasePlanDetails) {
            YkDruginventory ykdrug= new YkDruginventory();
            System.err.println(ykdpd.getDrugPrice());
            ykdrug.setDrugId(ykdpd.getDrugId());
            ykdrug.setYkDrvenName(ykdpd.getYfDruginformation().getDrugName());
            ykdrug.setYkDrvenBatch(ykdpd.getYkBatch());
            ykdrug.setYkSelingprice(ykdpd.getDrugPrice());
            ykdrug.setYkDrvenMftdate(ykdpd.getYkDate());
            ykdrug.setYkDrvenCount(ykdpd.getYkRuku());
            drugStorageMapper.putstorage(ykdrug);
        }
        YkDrugpurchasePlan plan = new YkDrugpurchasePlan();
        plan.setYkPurchaseIs(3L);
        plan.setYkPurchaseId(id);
        ydpm.updateById(plan);//修改执行计划状态


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
