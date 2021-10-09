package cn.gson.hisspring.model.pojos.pojos_vo;

import cn.gson.hisspring.model.pojos.*;
import lombok.Data;

import java.util.List;

/**
 *  问诊保存时新增的VO类
 */
@Data
public class RecordVo {

    private MzMedicalRecord medicalRecordObject;//就诊记录表

    private MzCaseHistory historyObject;//病历表

    private MzRecipe recipeObject;//处方对象里面包含 西药中药list

    public TjCodeMan tjCodeManObject; //体检单表
    public List<TjManResult> tjManResultList;//体检中间项目集合表

    public MzSurgeryStamp surgeryStampObject; //手术单表
    public List<MzCenterSurgery> centerSurgeryList; //手术集合表

}
