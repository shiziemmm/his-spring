package cn.gson.hisspring.controller.checkout_module_controller;

import cn.gson.hisspring.model.pojos.SsOperationAnaesthesia;
import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.service.checkout_module_service.SprojectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
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
//    单个
    @RequestMapping("ssprot")
    public List<SsOperationProject> singeProject(Integer projectId){
        return  sprojectService.singeProject(projectId);
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
