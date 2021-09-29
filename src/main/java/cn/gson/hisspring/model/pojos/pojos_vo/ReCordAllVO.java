package cn.gson.hisspring.model.pojos.pojos_vo;

import cn.gson.hisspring.model.pojos.*;
import lombok.Data;

import java.util.List;

/**
 * 包含掉所有的实体类的Vo
 */
@Data
public class ReCordAllVO {

    private MzMedicalRecord medicalRecordObject;//就诊记录
    private MzCaseHistory historyObject;//病历

    private MzRecipe recipeObject;//处方
    private List<MzXprescription> xpList;//西药
    private List<MzZprescription> zpList;//中药

    private TjCodeMan tjCodeManObject;//体检单表
    private List<TjManResult> tjManResultList;//体检中间项目集合表


    private MzSurgeryStamp surgeryStampObject; //手术单表
    private List<MzCenterSurgery> centerSurgeryList; //手术集合表
}
