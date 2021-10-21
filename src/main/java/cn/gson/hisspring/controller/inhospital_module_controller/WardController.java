package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.WardMapper;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.ZyWard;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import cn.gson.hisspring.model.service.inhospital_module_service.WardService;
import cn.gson.hisspring.model.service.jurisdiction_module_service.DepartmentKsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


/**
 * 病房controller类
 */
@RestController
@CrossOrigin
public class WardController {
    @Autowired
    WardService wds;//病房

    /**
     * 查询所有病房加病床
     * @return
     */
    @RequestMapping("zyWard")
    public List<ZyWard> selectWardAllPage(@RequestBody String str)  {
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        return wds.selectWardAllPage(selectExecuteVo);
    }

    /**
     * 新增修改病房
     */
    @RequestMapping("addOrUpdataWard")
    public boolean wardAddOrUpdate(@RequestBody String wardStr){
        ZyWard ward = JSON.parseObject(wardStr, ZyWard.class);//将病房对象字符串转换为病房对象
        return wds.wardInsertOrUpdate(ward);
    }

    /**
     * 判断病房名称是否存在
     */
    @RequestMapping("wdNameSelectRepetition")
    public boolean selectWdNameRepetition(String wdName){
        return wds.selectWdNameRepetition(wdName);
    }

    /**
     * 根据科室编号查询病房信息
     *
     */
    @RequestMapping("wardByKsId")
    public List<ZyWard> selectWardByKsId(String ksId){
        return wds.selectWardByKsId(ksId);
    }

}
