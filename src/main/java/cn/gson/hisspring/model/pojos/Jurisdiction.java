package cn.gson.hisspring.model.pojos;

import lombok.Data;

import java.util.List;

@Data//get  set方法
public class Jurisdiction {

    private long jId;
    private String jName;
    private List<FunctionJurisdiction> list;


}
