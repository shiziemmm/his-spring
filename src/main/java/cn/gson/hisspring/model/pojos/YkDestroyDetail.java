package cn.gson.hisspring.model.pojos;

import lombok.Data;

//销毁申请详表

@Data//get  set方法
public class YkDestroyDetail {

    private long ykDestroyId;
    private long ykDestId;
    private long drugId;
    private long ykDrvenId;
    private String ykDestroyIs;
    private String ykDestroyCount;


}
