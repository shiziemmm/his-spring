package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YfDrugcategory;
import cn.gson.hisspring.model.pojos.YfDruginformation;
import cn.gson.hisspring.model.pojos.YkDrugspecifcations;
import cn.gson.hisspring.model.pojos.YkSupplier;
import cn.gson.hisspring.model.service.pharmacy_module_service.YfDruginformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class YfDruginformationController {
    @Autowired
    YfDruginformationService information_service;
    //查询所有药品
    @RequestMapping("yp-all")
    public List<YfDruginformation> yfDruginformations(){
        return  information_service.queryById();
    }
    //新增药品
    @RequestMapping("yp-add")
    public String addDrug(@RequestBody YfDruginformation yfDruginformation){
        System.err.println(yfDruginformation);
        try {
            if(yfDruginformation.getDrugId()==0){
                System.out.println("走新增");
                information_service.addDrug(yfDruginformation);
            }else{
                System.out.println("走修改");
                information_service.updaDrug(yfDruginformation);
            }
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //查询规格
    @RequestMapping("all-spec")
    public List<YkDrugspecifcations> allspec(){
        return information_service.allspec();
    }
    //查询供应商
    @RequestMapping("all-supp")
    public List<YkSupplier> allsupp(){
        return information_service.allsupp();
    }
    //查询类别
    @RequestMapping("all-drca")
    public List<YfDrugcategory> alldrca(){
        return information_service.alldrca();
    }
}
