package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.WardMapper;
import cn.gson.hisspring.model.pojos.ZyWard;
import cn.gson.hisspring.model.service.inhospital_module_service.WardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 病房controller类
 */
@RestController
@CrossOrigin
public class WardController {
    @Autowired
    WardService wds;//病房

    @RequestMapping("zyWard")
    public List<ZyWard> selectWardAllPage(){
        return wds.selectWardAllPage();
    }





}
