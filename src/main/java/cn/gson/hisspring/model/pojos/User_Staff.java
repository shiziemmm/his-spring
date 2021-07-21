package cn.gson.hisspring.model.pojos;

import lombok.Data;

import java.sql.Timestamp;
@Data
public class User_Staff {
    private long uid;
    private String uname;
    private long sid;
    private String sname;
    private String ssore;
    private String sphone;
    private Timestamp sdate;
    private long ksId;
    private long tId;


}
