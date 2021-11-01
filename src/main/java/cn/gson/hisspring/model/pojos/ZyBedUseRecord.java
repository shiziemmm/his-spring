package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data//get  set方法
public class ZyBedUseRecord {

    @TableId("ur_id")
    private long urId;


    private Long bdId;
    private Long ptNo;
    private java.sql.Timestamp urUseDate;
    private java.sql.Timestamp urEndDate;
    private Double urBedPrice;


    public ZyBedUseRecord(Long bdId, Long ptNo, Timestamp urUseDate, Double urBedPrice) {
        this.bdId = bdId;
        this.ptNo = ptNo;
        this.urUseDate = urUseDate;
        this.urBedPrice = urBedPrice;
    }

    public ZyBedUseRecord(long urId, Timestamp urEndDate) {
        this.urId = urId;
        this.urEndDate = urEndDate;
    }

    public ZyBedUseRecord() {
    }
}
