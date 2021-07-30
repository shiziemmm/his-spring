package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
import cn.gson.hisspring.model.service.outpatient_module_service.MzRecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 处方表 Controller
 */
@CrossOrigin
@RestController
public class MzRecipeController {
    @Autowired
    MzRecipeService recipeService;


    @RequestMapping("addRecipe")
    public String addRecipe(@RequestBody RecordVo recordVo){
        try {
            System.err.println(recordVo);
            recipeService.addRecipe(recordVo);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
