package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.Frequency;
import cn.gson.hisspring.model.service.jurisdiction_module_service.FrequencyService;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin
@RestController
public class FrequencyController {
    @Autowired
    FrequencyService fs;

    /**
     * 查看班次
     * @return
     */
    @RequestMapping("select-fre")
    public List<Frequency> selectAll(){
        return fs.selectAll();
    }

    /**
     * 新增班次
     * @param grant
     */
    @RequestMapping("add-fre")
    public void addFre(@RequestParam("grant") String grant){
        Map map = JSON.parseObject(grant, Map.class);
        //类别id
        Integer fcId = Integer.parseInt(map.get("bcId").toString());
        //开始时间
        List<String> start=  (List<String>) map.get("start");
        //结束时间
        List<String> end=  (List<String>) map.get("end");
        List<Map> mapList = new ArrayList<>();
        for(int i =0 ;i<start.size(); i++){
            Map map1 = new HashMap();
            map1.put("start",start.get(i));
            map1.put("end",end.get(i));
            mapList.add(map1);
        }
        fs.addRoleInfo(mapList,fcId);
    }
    @PostMapping("edit-fre")
    public int editFre(@RequestBody Frequency frequency){
        int i = fs.editFre(frequency);
        if(i>0){
            return 1;
        }else{
            return 0;
        }
    }

}
