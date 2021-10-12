package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YfDruginventory;
import cn.gson.hisspring.model.service.pharmacy_module_service.YfDruglnventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class YfDruglnventoryController {
    @Autowired
    YfDruglnventoryService yfDruglnventoryService;

    /*查询药房库存*/
    @RequestMapping("YF-repertory")
    public List <YfDruginventory> allYFlnventory(){
        return yfDruglnventoryService.allYFlnventory();
    }
}
