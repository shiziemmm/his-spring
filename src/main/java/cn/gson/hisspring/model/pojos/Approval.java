package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class Approval {

    private long aId;
    private String aDate;
    private long aType;
    private String aName;
    private String aTheme;
    private String sId;
    private String orderId;


}
