package cn.gson.hisspring.model.pojos.pojos_vo;

import lombok.Data;

/**
 * 医嘱执行所需药品库存
 */
@Data
public class PharmacyVo {
    private String desDrugName;//药品名称
    private String desUnit;//药品规格
    private String desUsage;//使用方法
    private Double desPrice;//药品价格
    private Long desDrugId;//药品编号

    private Long kc;//药品库存
    private String ksName;//科室名称
    private Long ksId;//科室编号

    public String getDesDrugName() {
        return desDrugName;
    }

    public void setDesDrugName(String desDrugName) {
        this.desDrugName = desDrugName;
    }

    public String getDesUnit() {
        return desUnit;
    }

    public void setDesUnit(String desUnit) {
        this.desUnit = desUnit;
    }

    public String getDesUsage() {
        return desUsage;
    }

    public void setDesUsage(String desUsage) {
        this.desUsage = desUsage;
    }

    public Double getDesPrice() {
        return desPrice;
    }

    public void setDesPrice(Double desPrice) {
        this.desPrice = desPrice;
    }

    public Long getDesDrugId() {
        return desDrugId;
    }

    public void setDesDrugId(Long desDrugId) {
        this.desDrugId = desDrugId;
    }

    public Long getKc() {
        return kc;
    }

    public void setKc(Long kc) {
        this.kc = kc;
    }

    public String getKsName() {
        return ksName;
    }

    public void setKsName(String ksName) {
        this.ksName = ksName;
    }

    public Long getKsId() {
        return ksId;
    }

    public void setKsId(Long ksId) {
        this.ksId = ksId;
    }
}
