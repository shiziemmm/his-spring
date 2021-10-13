package cn.gson.hisspring.model.service.pharmacy_module_service;


import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.MzXprescriMapper;
import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YfMzRecipeMapper;
import cn.gson.hisspring.model.pojos.MzRecipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MzRecipServiceImp {
    @Autowired
    YfMzRecipeMapper mzcipe;

    //查询已经缴费的处方单
    public List<MzRecipe> allMzRecipe(){
        return mzcipe.allMzRecipess();
    }
}
