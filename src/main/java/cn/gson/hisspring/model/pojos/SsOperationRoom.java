package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data//get  set方法
public class SsOperationRoom {
    @TableId(value = "operation_id", type = IdType.AUTO)
    private long operationId;
    private String operationName;
    private String operationZt;
    private String operationRoomAddress;
    private long sId;
    private String operationType;
    private long ksId;
    @TableField(exist = false)
    private DepartmentKs deptks;//科室

    @TableField(exist = false)
    private Staff BaseResultMap;//科室
}
