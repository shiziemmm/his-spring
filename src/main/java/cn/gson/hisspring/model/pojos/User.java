package cn.gson.hisspring.model.pojos;

import lombok.Data;

import java.util.List;

@Data//get  set方法
public class User {

  private long uId;
  private String uName;
  private String uPswd;
  private Staff list;


}
