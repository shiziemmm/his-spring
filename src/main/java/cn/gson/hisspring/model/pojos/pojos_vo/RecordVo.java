package cn.gson.hisspring.model.pojos.pojos_vo;

import cn.gson.hisspring.model.pojos.MzCaseHistory;
import cn.gson.hisspring.model.pojos.MzMedicalRecord;
import cn.gson.hisspring.model.pojos.MzRecipe;
import lombok.Data;

/**
 *  问诊保存时新增的VO类
 */
@Data
public class RecordVo {

    private MzMedicalRecord medicalRecordObject;//就诊记录表
    private MzRecipe recipeObject;//处方对象里面包含 西药中药list
    private MzCaseHistory historyObject;//病历表

}
