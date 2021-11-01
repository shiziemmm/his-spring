package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

@Data//get  set方法
public class User {
    @TableId(type = IdType.AUTO)//自增id
    private long uId;
    private String uName;
    private String uPswd;

    @TableField(exist = false)
    private Staff list;


}
