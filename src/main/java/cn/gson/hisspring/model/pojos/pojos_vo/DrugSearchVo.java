package cn.gson.hisspring.model.pojos.pojos_vo;

import lombok.Data;

@Data
public class DrugSearchVo {

    private String searchDrugUsage;//药品用法
    private String drugNameSearch;//药品模糊查询
    private String searchDrugUnit;//药品单位
    private String searchYfDrcaName;//类别搜索（中药、西药）


}
