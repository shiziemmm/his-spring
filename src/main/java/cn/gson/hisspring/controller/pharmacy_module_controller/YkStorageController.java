package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YkStorage;
import cn.gson.hisspring.model.service.pharmacy_module_service.YkStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class YkStorageController {
    @Autowired
    YkStorageService storgser;

    //查询全部的出入库记录
    @RequestMapping("allStorage")
    public List<YkStorage> allStorage(){
         return storgser.allStorage();
    }
}
