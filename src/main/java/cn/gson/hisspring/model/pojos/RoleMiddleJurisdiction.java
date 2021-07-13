package cn.gson.hisspring.model.pojos;

import lombok.Data;

import java.util.List;

@Data//get  set方法
public class RoleMiddleJurisdiction {

  private long rId;
  private long fctionId;
  List<FunctionJurisdiction> funs;

}
