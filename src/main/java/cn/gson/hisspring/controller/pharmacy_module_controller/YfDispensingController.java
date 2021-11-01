package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YfDispensing;
import cn.gson.hisspring.model.service.pharmacy_module_service.YfDispensingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class YfDispensingController {
    @Autowired
    YfDispensingService disser;

    /**
     * 发药记查询
     *
     * @param yfDispensing
     */
    @RequestMapping("allyfdisng")
    public List<YfDispensing> allyfdisng(YfDispensing yfDispensing) {
        return disser.allyfdisng(yfDispensing);
    }

}
