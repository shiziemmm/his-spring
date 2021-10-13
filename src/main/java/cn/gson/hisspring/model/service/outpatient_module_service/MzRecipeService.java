package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzRecipeMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzXprescriptionMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzZprescriptionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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

}
