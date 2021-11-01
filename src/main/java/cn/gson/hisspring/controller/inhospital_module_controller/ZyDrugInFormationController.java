package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.pojos_vo.DrugSearchVo;
import cn.gson.hisspring.model.pojos.pojos_vo.DrugVo;
import cn.gson.hisspring.model.service.inhospital_module_service.ZyDrugInFormationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 药品耗材查询
 */

@RestController
@CrossOrigin
public class ZyDrugInFormationController {
    @Autowired
    ZyDrugInFormationService zds;

    @RequestMapping("select-drug-drugName")
    public List<DrugVo> selectDrugByDrugName(@RequestBody DrugSearchVo drugSearchVo) {
        return zds.selectDrugByDrugName(drugSearchVo);
    }


    @RequestMapping("select-drug-unit")
    public List<Object> selectDrugUnit() {
        return zds.selectDrugUnit();
    }

    @RequestMapping("select-drug-usage")
    public List<Object> selectDrugUsage() {
        return zds.selectDrugUsage();
    }
}
