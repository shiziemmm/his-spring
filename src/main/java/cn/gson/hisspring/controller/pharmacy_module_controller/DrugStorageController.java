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
    public void putstorage(@RequestParam("grant") String grant){
        JSONObject o = JSONObject.parseObject(grant);
        System.err.println(grant);
        List<YkDrugpurchasePlanDetails> list = new ArrayList<>();

        grant = JSON.toJSONString(list);// 放进去的是List
        System.err.println(o.get("str").toString()+"输出");
        List<YkDrugpurchasePlanDetails> funs = JSONArray.parseArray(o.get("str").toString(),YkDrugpurchasePlanDetails.class);
        System.err.println(funs+"funssss");
//        List<YkDrugpurchasePlanDetails> objList3 = JSON.parseArray(grant, YkDrugpurchasePlanDetails.class);// 取一个Lis
//        List<YkDrugpurchasePlanDetails> ykDrugpurchasePlanDetails = JSON.parseArray(str, YkDrugpurchasePlanDetails.class);
//        System.err.println(str);
//        System.err.println(funs);
//        drugStorageService.putstorage(funs);
    }
}
