package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class TjCodeMan {

  private long manId;
  private String manName;
  private double codePay;
  private long typeId;

}
