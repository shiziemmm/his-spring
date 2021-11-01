package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class MzSignalRetreat {

    private long srNumber;
    private java.sql.Timestamp srTime;
    private String rtNumber;
    private String srWhy;


}
