package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YfDruginformation;
import cn.gson.hisspring.model.service.pharmacy_module_service.YfDruginformation_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class YfDruginformation_Controller {
    @Autowired
    YfDruginformation_Service information_service;

    @RequestMapping("yp-all")
    public List<YfDruginformation> yfDruginformations(){
        return  information_service.queryById();
    }


}
