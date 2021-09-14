package cn.gson.hisspring.model.pojos.pojos_vo;

import lombok.Data;

/**
 * 发药实体类
 */
@Data
public class DispensingVo {
    private Long dvSid;//员工编号
    private Long dvDrugId;//药品编号
    private Long dvKsId;//科室编号
    private String dvName;//员工名称

    public Long getDvSid() {
        return dvSid;
    }

    public void setDvSid(Long dvSid) {
        this.dvSid = dvSid;
    }

    public Long getDvDrugId() {
        return dvDrugId;
    }

    public void setDvDrugId(Long dvDrugId) {
        this.dvDrugId = dvDrugId;
    }

    public Long getDvKsId() {
        return dvKsId;
    }

    public void setDvKsId(Long dvKsId) {
        this.dvKsId = dvKsId;
    }

    public String getDvName() {
        return dvName;
    }

    public void setDvName(String dvName) {
        this.dvName = dvName;
    }
}
