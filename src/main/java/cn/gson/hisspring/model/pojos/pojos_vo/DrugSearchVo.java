package cn.gson.hisspring.model.pojos.pojos_vo;

import lombok.Data;

@Data
public class DrugSearchVo {

    private String searchDrugUsage;//药品用法
    private String drugNameSearch;//药品模糊查询
    private String searchSpecId;//药品规格
    private String searchYfDrcaName;//类别搜索（中药、西药）
    private String searchIs;//是否处方药


}
