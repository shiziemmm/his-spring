package cn.gson.hisspring.model.pojos.pojos_vo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

/**
 * 耗材
 */
@Data
@TableName(value = "HC_ind_Consumables")
public class ZyHCindConsumables {

    @TableId(value = "consumables_Id")
    private Integer consumablesId;

    private String consumablesName;//耗材名称
    private long consumablesPhy;//耗材数量
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Timestamp consumablesPurchase;//保质期
    private String consumablesUnit;//耗材规格
    private Double consumablesPrice;//耗材价格

    public ZyHCindConsumables(Integer consumablesId, long consumablesPhy) {
        this.consumablesId = consumablesId;
        this.consumablesPhy = consumablesPhy;
    }

    public ZyHCindConsumables() {
    }
}
