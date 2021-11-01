package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data//get  set方法
public class Department {

    @TableId(value = "de_id")
    private long deId;
    private String deName;
    private java.sql.Timestamp deDate;


}
