package cn.gson.hisspring.model.pojos;

import lombok.Data;

import java.util.List;

@Data//get  set方法
public class FunctionJurisdiction {

  private long fctionId;
  private String fctionName;
  private String fctionAssembly;
  private String fctionSrc;
  private String fctionIcon;
  private String fctionState;
  private long fctionCid;
  private List<FunctionJurisdiction> list;



}
