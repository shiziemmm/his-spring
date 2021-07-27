package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.pojos_vo.Time;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class Times {

    @RequestMapping("data-time")
    @ResponseBody
    public void saceGrant(@RequestParam("grant") String grant){
//        JSONObject o = JSONObject.parseObject(grant);
//        Integer roleId = Integer.parseInt(o.get("roleId").toString());
//        List<Integer> funs = JSONArray.parseArray(o.get("Shitime").toString(),Integer.TYPE);
        System.out.println(grant);

    }
}
