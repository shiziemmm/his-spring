package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyDoctorEnjoinRecordDetails {

    private long dersId;
    private long derId;
    private java.sql.Timestamp dersExecuteDate;
    private String dersDrugNa;
    private String dersDrugPrice;
    private long drugId;
    private long ptNo;

}
