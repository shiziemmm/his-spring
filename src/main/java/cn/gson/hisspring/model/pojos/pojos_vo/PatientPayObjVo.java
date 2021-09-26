package cn.gson.hisspring.model.pojos.pojos_vo;

import lombok.Data;

/**
 * 病人新开费用实体类
 */
@Data
public class PatientPayObjVo {
    private String poText;
    private Long poSid;
    private  Double poPrice;
    private Long poPtNo;
}
