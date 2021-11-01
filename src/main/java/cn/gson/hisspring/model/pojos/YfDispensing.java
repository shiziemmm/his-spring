package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;
import java.util.Date;

/**
 * 药房发药记录
 */
@Data
public class YfDispensing {

    @TableId(value = "yf_dis_id")
    private long yfDisId;
    @JsonFormat(pattern = "yyyy-MM-dd-HH:mm:ss", timezone = "GMT+8")
    private Timestamp yfDisDate;
    private String yfDisGo;
    private Long sId;
    private String yfDisName;
    private String yfDisDurgName;
    private Long yfDisDurgCount;
    private Long drugId;
    private Long yfDrugIs;
    private String yfDrvenBatch;

    @TableField(exist = false)
    private Staff staff;/*员工表*/
    @TableField(exist = false)
    private YfDruginformation yfDruginformation;//药品信息


    public void setsId(Long sId) {
        this.sId = sId;
    }

    public YfDispensing() {
    }

    public YfDispensing(String ykDisGo, Long sId, String ykDisName, String yfDisDurgName, Long yfDisDurgCount, Long drugId, Long is, String yfDrvenBatch) {
        this.yfDisDate = new Timestamp(new Date().getTime());
        this.yfDisGo = ykDisGo;
        this.sId = sId;
        this.yfDisName = ykDisName;
        this.yfDisDurgName = yfDisDurgName;
        this.yfDisDurgCount = yfDisDurgCount;
        this.drugId = drugId;
        this.yfDrugIs = is;
        this.yfDrvenBatch = yfDrvenBatch;
    }
}
