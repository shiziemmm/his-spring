package cn.gson.hisspring.model.pojos.pojos_vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 *住院查询要实体类
 */
@Data
@TableName("YF_DrugInformation")
public class DrugVo {
    private Long drugId;
    private String drugName;
    private String drugBarCode;
    private Double drugPrice;
    private String drugUsage;
    private Long ykSpecId;
    private Long ykSupplierId;
    private Long yfDrcaId;
    private String drugUpper;
    private String drugRemark;
    private String drugUnit;
    private String drugSpecification;
    private String drugPastDate;

    //关系
    @TableField(exist = false)
    private String yfDrcaName;//药品类别
}
