package cn.gson.hisspring.model.pojos;

import lombok.Data;

@Data//get  set方法
public class SsOperationProject {

  private long projectId;
  private String projectName;
  private double projectPay;
  private String projectType;
  private String projectPosition;
  private long ksId;
  private String projectIndication;
  private String projectTaboo;
  private String projectMatters;


}