package cn.gson.hisspring.controller.checkout_module_controller;

import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.service.checkout_module_service.SprojectService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 手术项目controll
 */
@RestController
@CrossOrigin
public class SsobjectControll {
    @Autowired
    SprojectService sprojectService;//手术项目
    //所有
    @RequestMapping("sprot")
    public List<SsOperationProject> ssOperationProjects(){
        return  sprojectService.allProject();
    }
    //所有手术室
    @RequestMapping("sssRoom")
    public List<SsOperationRoom> allSroom(String seach){
        return  sprojectService.allSroom(seach);
    }
    //所有手术申请
    @RequestMapping("sssApply")
    public List<SsOperationApply> allSapply(String seach){
        return  sprojectService.allSApply(seach);
    }
    //所有手术记录
    @RequestMapping("ssdDetail")
    public List<SsOperationDetails> allSDetail(String seach){
        return  sprojectService.allSdetails(seach);
    }
    //单手术记录
    @RequestMapping("ssdaDetail")
    public List<SsOperationDetails> allSDetail(Integer operationNum){
        return  sprojectService.aoneSdetails(operationNum);
    }
    //查询单个手术项目表用于去重
    @RequestMapping("ssqProject")
    public List<SsOperationProject> ssOperatioqProjects(String projectName){
        return  sprojectService.alonqProject(projectName);
    }
    //根据手术id查手术记录
    @RequestMapping("ssdproDetail")
    public List<SsOperationDetails> allproDetail(Integer projectId){
        return  sprojectService.aoneprSdetails(projectId);
    }





    //    单个手术项目
    @RequestMapping("ssprot")
    public List<SsOperationProject> singeProject(Integer projectId){
        return  sprojectService.singeProject(projectId);
    }
    //    单个手术项目主表
    @RequestMapping("alone-pro")
    public List<SsOperationProject> aloneProject(Integer projectId){
        return  sprojectService.aloneProject(projectId);
    }

    @RequestMapping("allDescSpro") //排序所有手术信息
    public List<SsOperationProject> descSpro(String input){
        return sprojectService.selectAllSsObject(input);
    }
    @RequestMapping("allDescSpro1") //排序所有住院手术信息
    public List<SsOperationProject> descSpro1(String input){
        return sprojectService.selectAllSsObject1(input);
    }

    /**
     * 新增修改手术项目
     */

    @RequestMapping("addOrUpdataProj")
    public boolean projAddOrUpdate(@RequestBody String projstr){
        System.out.println(projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将病房对象字符串转换为病房对象
        SsOperationProject proj = JSON.parseObject(map.get("proj").toString(), SsOperationProject.class);
        System.out.println(proj);

//        System.out.println("实体"+proj);
        return sprojectService.projectUpdate(proj);
    }
    /**
     * 新增修改手术室
     */

    @RequestMapping("aOrUroom")
    public boolean roomjAddOrUpdate(@RequestBody String projstr){
        System.out.println(projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将病房对象字符串转换为病房对象
        SsOperationRoom proj = JSON.parseObject(map.get("proj").toString(), SsOperationRoom.class);
        System.out.println(proj);
        return sprojectService.sssUpdate(proj);
    }
    /**
     * 新增修改手术申请
     */

    @RequestMapping("aOrUApply")
    public boolean applyAddOrUpdate(@RequestBody String projstr){
        System.out.println(projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将病房对象字符串转换为病房对象
        SsOperationApply proj = JSON.parseObject(map.get("proj").toString(), SsOperationApply.class);
        System.out.println(proj);
        return sprojectService.ssqUpdate(proj);
    }

    //    修改费用
    @RequestMapping("upd-pricess")
    public String updetprice(double price,long ptNo){
        System.err.println(price+"ddd");
        System.err.println(ptNo+"qqqqqqqqq");
        try {
            sprojectService.updetPrice(price,ptNo);

            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    /**
     * 新增修改手术记录
     */

    @RequestMapping("aOrUDatils")
    public boolean datailAddOrUpdate(@RequestBody String projstr){
        System.out.println(projstr);
        Map map = JSON.parseObject(projstr, Map.class);//将病房对象字符串转换为病房对象
        SsOperationDetails proj = JSON.parseObject(map.get("proj").toString(), SsOperationDetails.class);
        System.out.println(proj);
        return sprojectService.ssjlUpdate(proj);
    }
    //    修改手术室状态
    @PostMapping("upd-roomzt")
    public String updetroom(Integer operationZt,Integer operationId){
        try {
            sprojectService.updazt(operationZt,operationId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //    删除手术项目
    @PostMapping("delet-sprot")
    public String deletlist(Integer projectId){
        try {
            sprojectService.delet(projectId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
    //    删除手术申请
    @PostMapping("delet-ssap")
    public String deletappl(Integer applyId){
        try {
            sprojectService.deletapl(applyId);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    //查询所有手术药品
    @RequestMapping("yp-ss")
    public List<YfDruginformation> yfDruginformations(){
        return  sprojectService.querysById();
    }
    //单个项目可选麻醉
    @RequestMapping("mzprot")
    public List<SsOperationAnaesthesia> anaProject(Integer projectId){
        return  sprojectService.AnaProject(projectId);
    }
    //s所有麻醉
    @RequestMapping("mzproject")
    public List<SsOperationAnaesthesia> anasProject(){
        return  sprojectService.allAnaesthesia();
    }
}
