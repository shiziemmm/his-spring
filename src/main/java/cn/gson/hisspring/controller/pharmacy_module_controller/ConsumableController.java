package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.HcIndConsumables;
import cn.gson.hisspring.model.service.pharmacy_module_service.ConsumableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class ConsumableController {
    @Autowired
    ConsumableService consumableService;

    //查询耗材
    @RequestMapping("all-mables")
    public List<HcIndConsumables> allConsumables() {
        return consumableService.allConsumables();
    }

    //新增修改
    @RequestMapping("add-mables")
    public String addConsumables(@RequestBody HcIndConsumables hcIndConsumables) {
        System.err.println(hcIndConsumables);
        try {
            if (hcIndConsumables.getConsumablesId() == 0) {
                consumableService.addConsumables(hcIndConsumables);
            } else {
                consumableService.updateConsumables(hcIndConsumables);
            }
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "false";
        }
    }
}
