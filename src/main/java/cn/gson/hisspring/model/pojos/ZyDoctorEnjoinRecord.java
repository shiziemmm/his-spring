package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyDoctorEnjoinRecord {

    private long derId;
    private java.sql.Timestamp derDate;
    private long sId;
    private double derBedCost;
    private double derTotalPrice;


}
