package cn.gson.hisspring.model.pojos;

import lombok.Data;

//采购退货详表

@Data//get  set方法
public class YkPurchasereturnDetail {

    private long ykRdetailId;
    private long ykReturnId;
    private long ykRdetailCount;
    private double ykRdetailPrice;
    private long ykPoDetailsId;


}
