package cn.gson.hisspring.controller.inhospital_module_controller;


import cn.gson.hisspring.model.pojos.ZyBed;
import cn.gson.hisspring.model.pojos.ZyWard;
import cn.gson.hisspring.model.service.inhospital_module_service.BedService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 病床controller层
 */

@RestController
@CrossOrigin
public class BedController {

    @Autowired
    BedService bs;


    /**
     * 新增或者修改病房
     * @param bed
     * @return
     */
    @RequestMapping("bedAddOrUpdate")
    public boolean bedAddOrUpdate(@RequestBody String bed){
        ZyBed beds = JSON.parseObject(bed, ZyBed.class);
        System.out.println(beds);
//        return false;
       return bs.bedAddOrUpdate(beds);
    };


    /**
     * 根据病床编号修改病床状态
     * @param bd
     * @return
     */
    @RequestMapping("bedUpdateBdIs")
    public boolean bedUpdateBdIs(@RequestBody String bd){
        Map map = JSON.parseObject(bd, Map.class);
        return bs.bedUpdateBdIs(Long.parseLong(map.get("bdId").toString()),Long.parseLong(map.get("bdIs").toString()));
    }


    /**
     * 根据病房编号查询病床
     * @param wdId
     * @return
     */
    @RequestMapping("bedSelectByWdId")
    public List<ZyBed> bedSelectByWdId(Long wdId){
       return bs.bedSelectByWdId(wdId);
    }


}
