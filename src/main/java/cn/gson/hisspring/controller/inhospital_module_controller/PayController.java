package cn.gson.hisspring.controller.inhospital_module_controller;


import cn.gson.hisspring.model.pojos.ZyPay;
import cn.gson.hisspring.model.service.inhospital_module_service.PayService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 住院缴费controller
 */
@RestController
@CrossOrigin
public class PayController {

    @Autowired
    PayService ps;

    @RequestMapping("addPay")
    public boolean addPay(@RequestBody String str){
        System.out.println(str);
        ZyPay pay = JSON.parseObject(str, ZyPay.class);
        System.out.println(pay);
        return ps.addPay(pay);
    }
}
