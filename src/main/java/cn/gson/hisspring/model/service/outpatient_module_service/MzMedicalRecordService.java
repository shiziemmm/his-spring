package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalRecordMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzRecipeMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzXprescriptionMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzZprescriptionMapper;
import cn.gson.hisspring.model.pojos.MzMedicalRecord;
import cn.gson.hisspring.model.pojos.MzRecipe;
import cn.gson.hisspring.model.pojos.MzXprescription;
import cn.gson.hisspring.model.pojos.MzZprescription;
import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 就诊记录表 service
 */

@Service
@Transactional
public class MzMedicalRecordService {
    @Autowired
    MzMedicalRecordMapper medicalRecordMapper; //就诊记录mapper
    @Autowired
    MzRecipeMapper recipeMapper;//处方表
    @Autowired
    MzXprescriptionMapper xpMapper;//西药
    @Autowired
    MzZprescriptionMapper zpMapper;//中药

    /**
     添加处方表--只做处方 和就诊记录的添加
     */
    public void addRecipe(RecordVo recordVo ){
        MzMedicalRecord medicalRecordObject = recordVo.getMedicalRecordObject();

        MzRecipe recipeObject = recordVo.getRecipeObject();
        //新增就诊记录表
        if(recordVo.getMedicalRecordObject() !=null){

            medicalRecordMapper.insert(medicalRecordObject);
        }
        //新增处方
        if(recordVo.getRecipeObject() !=null){
            recipeObject.setMrNumber(medicalRecordObject.getMrNumber());
            recipeMapper.insert(recipeObject);
        }
        //新增西药
        if(!recordVo.getRecipeObject().getXpList().isEmpty()){
            List<MzXprescription> xpLists = recordVo.getRecipeObject().getXpList();
            for (MzXprescription xpList : xpLists) {
                xpList.setRecipeNumber(recipeObject.getRecipeNumber());//外键-新增处方单号
                System.err.println("xp="+xpList);
            }
           xpMapper.addListXp(xpLists);
        }
        //新增中药
        if(!recordVo.getRecipeObject().getZpList().isEmpty()){
            List<MzZprescription> zpList = recordVo.getRecipeObject().getZpList();
            for (MzZprescription mzZprescription : zpList) {
                mzZprescription.setRecipeNumber(recipeObject.getRecipeNumber());//外键-新增处方单号
                System.err.println("zp="+mzZprescription);
            }
            zpMapper.addListZp(zpList);
        }

    }
    /**
     *  查询就诊记录表
     */
    public void selectMedicalRecord(Long index){
        medicalRecordMapper.selectMzMedicalRecord(index);
    }




}
