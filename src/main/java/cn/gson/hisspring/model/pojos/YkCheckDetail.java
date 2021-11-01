package cn.gson.hisspring.model.pojos;

import lombok.Data;

//盘点详表

@Data//get  set方法
public class YkCheckDetail {

    private long ykCheckDetailId;
    private long ykCheckId;
    private long ykCheckDetailIs;
    private long drugId;
    private String ykCheckDetailDrugName;
    private long ykCheckDetailCount;


}
