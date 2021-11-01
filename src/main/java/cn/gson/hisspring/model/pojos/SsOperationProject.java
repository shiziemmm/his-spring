package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data//get  set方法
public class SsOperationProject {

    @TableId(value = "project_id", type = IdType.AUTO)
    private long projectId;
    private String projectName;
    private double projectPay;
    private String projectType;
    private String projectPosition;
    private long ksId;
    private String projectIndication;
    private String projectTaboo;
    private String projectMatters;
    private String projectNumber;

    @TableField(exist = false)
    private String ksName;

    @TableField(exist = false)
    private List<Integer> ssAn;


}
