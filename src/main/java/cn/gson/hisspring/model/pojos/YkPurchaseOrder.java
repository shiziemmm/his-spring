package cn.gson.hisspring.model.pojos;

import lombok.Data;

//采购订单表

@Data//get  set方法
public class YkPurchaseOrder {

    private long ykPoId;
    private long sId;
    private String ykPoSName;
    private java.sql.Timestamp ykPoTime;


}
