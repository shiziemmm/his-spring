package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.ZyDrugInFormationMapper;
import cn.gson.hisspring.model.pojos.pojos_vo.DrugSearchVo;
import cn.gson.hisspring.model.pojos.pojos_vo.DrugVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 药品耗材查询
 */
@Service
public class ZyDrugInFormationService {
    @Autowired
    ZyDrugInFormationMapper zdm;//药品mapper


    /**
     * 根据条件查询
     * @return
     */
    public List<DrugVo> selectDrugByDrugName(DrugSearchVo search){
       return zdm.selectDrugByDrugName(search);
    }

    /**
     * 查询所有药品单位
     */
    public List<Object> selectDrugUnit(){
        return zdm.selectDrugUnit();
    }

    /**
     * 查询所有药品用法
     */
    public List<Object> selectDrugUsage(){
        return zdm.selectDrugUsage();
    }


}
