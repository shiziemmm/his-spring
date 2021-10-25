package cn.gson.hisspring.controller.checkout_module_controller;

import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.service.checkout_module_service.TjproService;
import cn.gson.hisspring.model.service.outpatient_module_service.MzCardBillService;
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
    @Autowired
    MzCardBillService bill;
    @RequestMapping("allDescTjpro") //排序所有检查信息
    public List<TjCodeProject> descSpro(String seach,Integer checkTpye){
        return major.selectAllTjObject(seach,checkTpye);
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
    public List<TjCodeMan> allManaa(String sermen){
        return major.selectAllman(sermen);
    }
    @RequestMapping("allMan1") //体检人员未填写
    public List<TjCodeMan> allManas(String sermen){
        return major.selectAllman1(sermen);
    }
    @RequestMapping("allMan2") //体检人员已填写
    public List<TjCodeMan> allManaw(String sermen){
        return major.selectAllman2(sermen);
    }
    @RequestMapping("allMan3") //体检人员根据id
    public List<TjCodeMan> allManrr(Integer manId){
        return major.selectman(manId);
    }
    @RequestMapping("aloneMp") //体检人员所含项目
    public List<TjCodeProject> allManp(Integer manId){
        return major.selectAlonMm(manId);
    }

    @RequestMapping("alonecpro") //根据名字查询项目用于去重
    public List<TjCodeProject> allsManp(String checkName){
        return major.selectslpro(checkName);
    }
    @RequestMapping("allsMan") //根据身份证查人员用于去重
    public List<TjCodeMan> allsManrr(String manSid){
        return major.selecsman(manSid);
    }

    @RequestMapping("aloneProt") //体检套餐所含检查指标44
    public List<TjCodeProject> allPro(Integer codeId){
        return major.selectTjpro(codeId);
    }
    @RequestMapping("aloneRes") //检查结果查询
    public List<TjManResult> allMan(Integer manId){
        return major.AllRes(manId);
    }
    @RequestMapping("aloneResss") //人员检查是否有结果
    public List<TjManResult> ssManres(Integer checkId){
        return major.sRes(checkId);
    }
    @RequestMapping("aloneCard") //体检套餐诊疗卡检查指标
    public List<MzMedicalCard> allMan(String sId){
        return major.alomCaed(sId);
    }
    /**
     * 新增修改检查结果
     */
    @RequestMapping("addOrUpdares")
    public boolean resAddOrUpdate(@RequestBody String projstr){
        System.out.println(projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将项目对象字符串转换为检查对象
        TjManResult troj = JSON.parseObject(map.get("troj").toString(), TjManResult.class);
        System.out.println(troj);
        return major.tjresUpdate(troj);
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
     * 新增扣费记录
     */
    @PostMapping("addbill")
    public String Updatebill(MzCardBill mcb){
        try {
            bill.addMzCardBill(mcb);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    /**
     * 新增修改体检人员单表
     */
    @RequestMapping("addOrUpdataMan1")
    public boolean TjmanUpdate1(@RequestBody String projstr){
        System.out.println(projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将项目对象字符串转换为检查对象
        TjCodeMan manj = JSON.parseObject(map.get("manj").toString(), TjCodeMan.class);
        System.out.println(manj);
        return major.tjmanUpdate1(manj);
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
    //    删除手术申请
    @PostMapping("delet-man")
    public String deletman(Integer manId){
        try {
            major.deletman(manId);
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
