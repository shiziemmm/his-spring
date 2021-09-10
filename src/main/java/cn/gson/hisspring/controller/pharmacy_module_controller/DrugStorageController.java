package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YkDruginventory;
import cn.gson.hisspring.model.service.pharmacy_module_service.DrugStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
/**
 * 药库
 */
public class DrugStorageController {
    @Autowired
    DrugStorageService drugStorageService;

    @RequestMapping("YK-repertory")
    public List<YkDruginventory> allDrugStorg() {
        return drugStorageService.allDrugStorg();
    }
}
