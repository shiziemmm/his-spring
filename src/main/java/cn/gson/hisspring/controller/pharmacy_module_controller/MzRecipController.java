package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.MzRecipe;

import cn.gson.hisspring.model.pojos.YkDrugpurchasePlan;
import cn.gson.hisspring.model.service.pharmacy_module_service.MzRecipServiceImp;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin /*跨域*/
public class MzRecipController {
    @Autowired
    MzRecipServiceImp mzser;

    //查询所有已经缴费的处方单
    @RequestMapping("allMzRecipe")
    public List<MzRecipe> allMzRecipe() {
        return mzser.allMzRecipe();
    }

    //发药
    @RequestMapping("fayao")
    public String fayao(@RequestBody String str) {
        try {
            Map map = JSON.parseObject(str, Map.class);
            MzRecipe mzRecipe = JSON.parseObject(map.get("mzRecipe").toString(), MzRecipe.class);
            System.err.println(mzRecipe);
            Long sId = JSON.parseObject(map.get("sId").toString(), Long.class);
            mzser.fayao(mzRecipe, sId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }

    }
}
