package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

//检查项目
@Data//get  set方法
public class TjCodeProject {
    @TableId(value = "check_id", type = IdType.AUTO)
    private long checkId;
    private String checkName;
    private double checkPay;
    private String indexName;
    private String indexSignificance;
    private long ksId;
    private long checkTpye;
    @TableField(exist = false)
    private DepartmentKs deptks;
    @TableField(exist = false)
    private long codeId;


}
