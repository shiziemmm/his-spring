package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzRecipeMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzXprescriptionMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzZprescriptionMapper;
import cn.gson.hisspring.model.pojos.MzRecipe;
import cn.gson.hisspring.model.pojos.MzXprescription;
import cn.gson.hisspring.model.pojos.MzZprescription;
import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 处方表service
 */
@Service
@Transactional
public class MzRecipeService {
    @Autowired
    MzRecipeMapper recipeMapper;

    /**
     * 修改处方表的缴费状态
     */
    public void updateStateRecipe(String index){
        //条件构造寻找对应的id
        QueryWrapper qw = new QueryWrapper();
        qw.eq("recipe_number",index);
        MzRecipe mzRecipe = recipeMapper.selectOne(qw);
        recipeMapper.updateById(mzRecipe);
    }
}
