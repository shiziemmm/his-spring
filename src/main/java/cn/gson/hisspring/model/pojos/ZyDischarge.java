package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class ZyDischarge {

    @TableId(type = IdType.AUTO)
    private long dgId;
    private Long ptNo;
    private java.sql.Timestamp dgDate;
    private Long sId;
    private String bdName;
    private Double dgDepositPrice;
    private Double dgUsedPrice;
    private Double dgBjPrice;
    private Double dgSjPrice;
    private Integer dgDay;

    //关系
    @TableField(exist = false)
    private Long dgaId;//申请出院编号
    @TableField(exist = false)
    private ZyPatientBase patientBase;//住院信息

}
