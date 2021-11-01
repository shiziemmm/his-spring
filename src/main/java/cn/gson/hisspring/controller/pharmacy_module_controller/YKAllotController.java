package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YfDruginventory;
import cn.gson.hisspring.model.pojos.YkAllot;
import cn.gson.hisspring.model.pojos.YkAllotdetail;
import cn.gson.hisspring.model.service.pharmacy_module_service.YKAllotService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin /*跨域*/
public class YKAllotController {
    @Autowired
    YKAllotService ykAllotService;

    /*调拨申请查询*/
    @RequestMapping("all-ykallot")
    public List<YkAllot> allykallot() {
        List<YkAllot> allykallot = ykAllotService.allykallot();
        return allykallot;
    }

    /*调拨详表查询*/
    @RequestMapping("all-detail")
    public List<YkAllotdetail> alldetail(String ykAllotId) {
        List<YkAllotdetail> allotdetails = ykAllotService.alldetail(ykAllotId);
        return allotdetails;
    }

    /*新增调拨*/
    @PostMapping("add-YkAllot")
    public void adddykallot(@RequestBody YkAllot ykAllot) {
        for (YfDruginventory yfDruginventory : ykAllot.getYfDruginventories()) {
            System.out.println(yfDruginventory.getYfDrvenName());
        }
        ykAllotService.adddykallot(ykAllot);
    }


    /**
     * 批量从药库调到药房
     */
    @RequestMapping("yk-batch-ykyf")
    public boolean batchYkYf(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);

        List<YkAllot> list = JSON.parseArray(map.get("allotDetail").toString(), YkAllot.class);//药库调拨集合
        Long sId = JSON.parseObject(map.get("sId").toString(), Long.class);//员工编号
        System.err.println(list);
        ykAllotService.addyf(list, sId);
        return false;
    }
}
