package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.MzRecipe;

import cn.gson.hisspring.model.service.pharmacy_module_service.MzRecipServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class MzRecipController {
    @Autowired
    MzRecipServiceImp mzser;

    //查询所有已经缴费的处方单
    @RequestMapping("allMzRecipe")
    public List<MzRecipe> allMzRecipe(){
        return mzser.allMzRecipe();
    }
}
