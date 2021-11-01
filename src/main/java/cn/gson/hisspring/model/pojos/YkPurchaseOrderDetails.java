package cn.gson.hisspring.model.pojos;

import lombok.Data;

//采购订单详表

@Data//get  set方法
public class YkPurchaseOrderDetails {

    private long ykPoDetailsId;
    private long drugId;
    private long ykPoId;
    private String ykDrugName;
    private long ykPoDetailsCount;
    private String ykPoDetailsSupplierName;
    private double ykPoDetailsPrice;
    private long ykPdDetailSalesCount;
    private long ykDrvenId;


}
