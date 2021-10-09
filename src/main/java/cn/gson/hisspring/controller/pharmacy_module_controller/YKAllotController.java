package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YfDruginventory;
import cn.gson.hisspring.model.pojos.YkAllot;
import cn.gson.hisspring.model.pojos.YkAllotdetail;
import cn.gson.hisspring.model.service.pharmacy_module_service.YKAllotService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class YKAllotController {
    @Autowired
    YKAllotService ykAllotService;

    /*调拨申请查询*/
    @RequestMapping("all-ykallot")
    public List<YkAllot> allykallot(){
        List <YkAllot> allykallot = ykAllotService.allykallot();
        return  allykallot;
    }
    /*调拨详表查询*/
    @RequestMapping("all-detail")
    public List<YkAllotdetail> alldetail(){
        List<YkAllotdetail> allotdetails = ykAllotService.alldetail();
        return allotdetails;
    }
    /*新增调拨*/
    @PostMapping("add-YkAllot")
    public void adddykallot( @RequestBody YkAllot ykAllot){
        System.err.println(ykAllot);
        for (YfDruginventory yfDruginventory : ykAllot.getYfDruginventories()) {
            System.out.println(yfDruginventory.getYfDrvenName());
        }
        ykAllotService.adddykallot(ykAllot);
    }
}
