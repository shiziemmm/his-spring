package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 住院医嘱处方药扣除记录
 */


@Data
public class ZyDrugPharmacyDispensingRecord {

    @TableId("pdr_id")
    private long pdrId;


    private String pdrCause;
    private Long pdrSid;
    private Long pdrKsid;
    private java.sql.Timestamp pdrDate;
    private Long drugId;
    private Long pdrCount;
    private String pdrDrugUnit;

    public ZyDrugPharmacyDispensingRecord(String pdrCause, Long pdrSid, Long pdrKsId, Long drugId, Long pdrCount, String pdrDrugUnit) {
        this.pdrCause = pdrCause;
        this.pdrSid = pdrSid;
        this.pdrKsid = pdrKsId;
        this.pdrDate = new Timestamp(new Date().getTime());
        this.drugId = drugId;
        this.pdrCount = pdrCount;
        this.pdrDrugUnit = pdrDrugUnit;
    }

    public ZyDrugPharmacyDispensingRecord() {
    }
}
