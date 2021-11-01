package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class ZyManResult {

    private long manResultId;
    private long checkId;
    private String manResult;
    private long ptNo;
    private java.sql.Timestamp manDate;


}
