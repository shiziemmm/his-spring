package cn.gson.hisspring.controller.checkout_module_controller;

import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.service.checkout_module_service.TjproService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 检查项目controll
 */
@RestController
@CrossOrigin
public class TjproController {
    @Autowired
    TjproService major;
    @RequestMapping("allDescTjpro") //排序所有检查信息
    public List<TjCodeProject> descSpro(String seach){
        return major.selectAllTjObject(seach);
    }
    @RequestMapping("allIndex") //所有检查指标
    public List<TjCodeIndex> allIndex(){
        return major.allIndex();
    }
    @RequestMapping("allTJtype") //所有套餐类型
    public List<TjCodeType> allTJtype(){
        return major.allType();
    }
    @RequestMapping("allMeal") //所有套餐
    public List<TjCodeMeal> allMeal(String checkIndex,String codeName,String codeType){
        return major.selectAllTjMeal(checkIndex,codeName,codeType);
    }
    @RequestMapping("aloneProt") //体检套餐所含检查指标
    public List<TjCodeProject> allPro(Integer codeId){
        return major.selectTjpro(codeId);
    }
    /**
     * 新增修改检查项目
     */
    @RequestMapping("addOrUpdataTroj")
    public boolean projAddOrUpdate(@RequestBody String projstr){
        System.out.println(projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将项目对象字符串转换为检查对象
        TjCodeProject troj = JSON.parseObject(map.get("troj").toString(), TjCodeProject.class);
        System.out.println(troj);
        return major.tprojectUpdate(troj);
    }
    /**
     * 新增修改体检套餐
     */
    @RequestMapping("addOrUpdataMroj")
    public boolean mrolddOrUpdate(@RequestBody String projstr){
        System.out.println(projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将项目对象字符串转换为检查对象
        TjCodeMeal mroj = JSON.parseObject(map.get("mroj").toString(), TjCodeMeal.class);
        System.out.println(mroj);
        return major.tjmealUpdate(mroj);
    }
    //    删除检查项目
    @PostMapping("delet-troj")
    public String deletlist(Integer index){
        try {
            major.delet(index);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
