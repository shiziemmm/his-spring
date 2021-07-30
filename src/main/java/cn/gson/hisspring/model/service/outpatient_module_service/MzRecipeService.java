package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzRecipeMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzXprescriptionMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzZprescriptionMapper;
import cn.gson.hisspring.model.pojos.MzXprescription;
import cn.gson.hisspring.model.pojos.MzZprescription;
import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
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
    MzRecipeMapper recipeMapper;//处方表
    @Autowired
    MzXprescriptionMapper xpMapper;//西药
    @Autowired
    MzZprescriptionMapper zpMapper;//中药
    @Autowired
    MzMedicalRecordService mzMedicalRecordService;/*就诊记录表*/

    /**
        添加处方表--只做处方的添加
     */
    public void addRecipe(RecordVo recordVo ){
        //新增处方
        recipeMapper.insert(recordVo.getRecipeObject());
        //新增西药
        List<MzXprescription> xpList = recordVo.getRecipeObject().getXpList();
        for (MzXprescription mzXprescription : xpList) {
            xpMapper.insert(mzXprescription);
        }
        //新增中药
        List<MzZprescription> zpList = recordVo.getRecipeObject().getZpList();
        for (MzZprescription mzZprescription : zpList) {
            zpMapper.insert(mzZprescription);
        }
        //新增就诊记录表
        mzMedicalRecordService.addMedicalRecord(recordVo.getMedicalRecordObject());

    }
}
