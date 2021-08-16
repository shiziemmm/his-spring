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
    private Long iss;//1是药品 2是耗材
    private Double drugParticle;//单粒价格
    private String drugQuantity;//每瓶数量
    private Long drugPrescription;//处方药

    //关系
    @TableField(exist = false)
    private String yfDrcaName;//药品类别

    @TableField(exist = false)
    private String specSpecification;
}
