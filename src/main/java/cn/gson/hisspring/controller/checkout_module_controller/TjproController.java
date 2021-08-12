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
    @RequestMapping("allMan") //体检人员排序
    public List<TjCodeMan> allMan(Integer manState,String sermen){
        return major.selectAllman(manState,sermen);
    }
    @RequestMapping("aloneMp") //体检人员所含项目
    public List<TjCodeProject> allManp(Integer manId){
        return major.selectAlonMm(manId);
    }
    @RequestMapping("aloneProt") //体检套餐所含检查指标
    public List<TjCodeProject> allPro(Integer codeId){
        return major.selectTjpro(codeId);
    }
    @RequestMapping("aloneRes") //体检套餐所含检查指标
    public List<TjManResult> allMan(Integer manId){
        return major.AllRes(manId);
    }
    @RequestMapping("aloneCard") //体检套餐诊疗卡检查指标
    public List<MzMedicalCard> allMan(String sId){
        return major.alomCaed(sId);
    }
    /**
     * 批量新增检查结果
     */
    @RequestMapping("resAdd")
    public boolean reaa(@RequestBody String projstr){
        System.out.println("222"+projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将项目对象字符串转换为检查对象
        System.out.println("111"+map);
        return major.inserjg((List) map.get("listArr"));
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
    /**
     * 新增修改体检人员
     */
    @RequestMapping("addOrUpdataMan")
    public boolean TjmanUpdate(@RequestBody String projstr){
        System.out.println(projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将项目对象字符串转换为检查对象
        TjCodeMan manj = JSON.parseObject(map.get("manj").toString(), TjCodeMan.class);
        System.out.println(manj);
        return major.tjmanUpdate(manj);
    }
    /**
     * 批量修改体检时间
     */
    @RequestMapping("updTjman")
    public String updman(String manTime,Integer manId){
        //将项目对象字符串转换为检查对象
        try {
            major.updTjman(manTime,manId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //    修改检查人员状态
    @PostMapping("upde-tman")
    public String updetman(Integer manState,Integer manId){
        try {
            major.updamzt(manState,manId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //    修改检查人员医生建议
    @PostMapping("upd-manY")
    public String updetman(String manProposal,Integer manId){
        try {
            major.updamanY(manProposal,manId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    } 
    //修改诊疗卡金额根据身份证
    @PostMapping("updeMoney")
    public String updMoney(Integer mcBalance,String mcIdCard){
        try {
            major.updMoney(mcBalance,mcIdCard);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
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
