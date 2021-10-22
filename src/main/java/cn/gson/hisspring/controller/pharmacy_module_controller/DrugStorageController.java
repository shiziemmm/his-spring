package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YfDruginventory;
import cn.gson.hisspring.model.pojos.YkDruginventory;
import cn.gson.hisspring.model.pojos.YkDrugpurchasePlanDetails;
import cn.gson.hisspring.model.service.pharmacy_module_service.DrugStorageService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin /*跨域*/
/**
 * 药库
 */
public class DrugStorageController {
    @Autowired
    DrugStorageService drugStorageService;
    /*查询药库*/
    @RequestMapping("YK-repertory")
    public List<YkDruginventory> allDrugStorg() {
        return drugStorageService.allDrugStorg();
    }

    /*药品入库*/
    @RequestMapping("putstorage")
    public void putstorage(@RequestBody String grant){
        Map map = JSON.parseObject(grant, Map.class);
        String id = map.get("ykPurchaseId").toString();
        System.err.println(id+"idid");
        List<YkDrugpurchasePlanDetails> ykDrugpurchasePlanDetails = JSON.parseArray(map.get("list").toString(), YkDrugpurchasePlanDetails.class);
        System.err.println(ykDrugpurchasePlanDetails+"77777777777777777777777777777");
//        List<YkDrugpurchasePlanDetails> objList3 = JSON.parseArray(grant, YkDrugpurchasePlanDetails.class);// 取一个Lis
//        List<YkDrugpurchasePlanDetails> ykDrugpurchasePlanDetails = JSON.parseArray(str, YkDrugpurchasePlanDetails.class);
//        System.err.println(str);
//        System.err.println(funs);
        drugStorageService.putstorage(ykDrugpurchasePlanDetails,id);
    }
}
