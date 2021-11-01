package cn.gson.hisspring.model.pojos;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 项目退费表
 */
@Data
public class ZyCheckoutOutpay {

    private long cpoId;
    private Double cpoPrice;
    private java.sql.Timestamp cpoDate;
    private Long manResultId;
    private Long ptNo;
    private Long sId;

    public ZyCheckoutOutpay(Double cpoPrice, Long manResultId, Long ptNo, Long sId) {
        this.cpoPrice = cpoPrice;
        this.cpoDate = new Timestamp(new Date().getTime());
        this.manResultId = manResultId;
        this.ptNo = ptNo;
        this.sId = sId;
    }

    public ZyCheckoutOutpay() {
    }
}
