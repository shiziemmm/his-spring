package cn.gson.hisspring.model.pojos.pojos_vo;

import cn.gson.hisspring.model.pojos.*;
import lombok.Data;

import java.util.List;

/**
 * 包含掉所有的实体类的Vo 这个和  RecordVo  都是一样的实体类VO
 */
public class ReCordAllVO {

    private MzMedicalRecord medicalRecordObject;//就诊记录
    private MzCaseHistory historyObject;//病历

    private MzRecipe recipeObject;//处方

    private TjCodeMan tjCodeManObject;//体检单表
    private List<TjManResult> tjManResultList;//体检中间项目集合表


    private MzSurgeryStamp surgeryStampObject; //手术单表
    private List<MzCenterSurgery> centerSurgeryList; //手术集合表

    private List<MzPayment> paymentList;


    public List<MzPayment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<MzPayment> paymentList) {
        this.paymentList = paymentList;
    }

    public MzMedicalRecord getMedicalRecordObject() {
        return medicalRecordObject;
    }

    public void setMedicalRecordObject(MzMedicalRecord medicalRecordObject) {
        this.medicalRecordObject = medicalRecordObject;
    }

    public MzCaseHistory getHistoryObject() {
        return historyObject;
    }

    public void setHistoryObject(MzCaseHistory historyObject) {
        this.historyObject = historyObject;
    }

    public MzRecipe getRecipeObject() {
        return recipeObject;
    }

    public void setRecipeObject(MzRecipe recipeObject) {
        this.recipeObject = recipeObject;
    }

    public TjCodeMan getTjCodeManObject() {
        return tjCodeManObject;
    }

    public void setTjCodeManObject(TjCodeMan tjCodeManObject) {
        this.tjCodeManObject = tjCodeManObject;
    }

    public List<TjManResult> getTjManResultList() {
        return tjManResultList;
    }

    public void setTjManResultList(List<TjManResult> tjManResultList) {
        this.tjManResultList = tjManResultList;
    }

    public MzSurgeryStamp getSurgeryStampObject() {
        return surgeryStampObject;
    }

    public void setSurgeryStampObject(MzSurgeryStamp surgeryStampObject) {
        this.surgeryStampObject = surgeryStampObject;
    }

    public List<MzCenterSurgery> getCenterSurgeryList() {
        return centerSurgeryList;
    }

    public void setCenterSurgeryList(List<MzCenterSurgery> centerSurgeryList) {
        this.centerSurgeryList = centerSurgeryList;
    }
}
