package cn.gson.hisspring.controller.checkout_module_controller;

import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.pojos.TjCodeProject;
import cn.gson.hisspring.model.service.checkout_module_service.TjproService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
