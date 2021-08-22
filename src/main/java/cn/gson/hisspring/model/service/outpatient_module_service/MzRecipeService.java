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
    @Autowired
    MzXprescriptionMapper xpMapper;
    @Autowired
    MzZprescriptionMapper zpMapper;
    /**
     * 修改处方表的缴费状态
     */
    public void updateStateRecipe(String index,String xmName){
        //条件构造寻找对应的id
        QueryWrapper qw = new QueryWrapper();
        qw.eq("recipe_Number",index);
        if(xmName.equals("西药处方")){
            List<MzXprescription> mzRecipe = xpMapper.selectList(qw);
            for (MzXprescription mzXprescription : mzRecipe) {
                mzXprescription.setRdStatePrice(1);
                xpMapper.updateById(mzXprescription);
            }
        }
        if(xmName.equals("中药处方")){
           List<MzZprescription> zp =  zpMapper.selectList(qw);
            for (MzZprescription mzZprescription : zp) {
                mzZprescription.setZpStatePrice(1);
                zpMapper.updateById(mzZprescription);
            }
        }
    }

}
