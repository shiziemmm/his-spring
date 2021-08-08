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
    public List<SsOperationRoom> allSroom(){
        return  sprojectService.allSroom();
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
