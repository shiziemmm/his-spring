package cn.gson.hisspring.model.pojos.pojos_vo;

import lombok.Data;

import java.sql.Timestamp;

/**
 * 修改病床实体类
 */

@Data
public class PatientUpdateBedVo {

    private Long bcId;
    private Long bcCurrentBdId;//调换之前的病床编号
    private Long bcLaterBdId;//调换之后的病床编号
    private Timestamp cDate;
    private Long ptNo;//住院编号
    private Double bdPrice;//病床价格
    private Long sId;//操作人
    private String bcCause;//调换原因


}
