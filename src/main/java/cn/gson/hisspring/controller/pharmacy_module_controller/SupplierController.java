package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YkSupplier;
import cn.gson.hisspring.model.service.pharmacy_module_service.SupplierService;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *供应商
 */

@RestController
@CrossOrigin /*跨域*/
public class SupplierController {
    @Autowired
    SupplierService supser;
    /*查询供应商*/
    @RequestMapping("gys-all")
    public List<YkSupplier> Allgys(){
        return supser.selectAllSupplier();
    }
    /*新增或修改供应商*/
    @RequestMapping("gys-add")
    public String addSupplier( String ykSupplier){
        YkSupplier ykSupplier1 = JSONObject.parseObject(ykSupplier,YkSupplier.class);
        System.out.println(ykSupplier1.getSupplierId());
        try {
             supser.insertSupplier(ykSupplier1);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    @RequestMapping("gys-update")
    public String updateSupplier( String ykSupplier){
        YkSupplier ykSupplier1 = JSONObject.parseObject(ykSupplier,YkSupplier.class);
        System.out.println(ykSupplier1.getSupplierId());
        try {
            supser.updateSupplier(ykSupplier1);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
