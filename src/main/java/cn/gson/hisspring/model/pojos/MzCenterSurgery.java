package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * 手术中间表
 */
@Data
public class MzCenterSurgery {
    @TableId(type = IdType.AUTO)
    private long susId;
    private long projectId;
    private long susNumber;
    private java.sql.Timestamp startDate;
    private java.sql.Timestamp overDate;
    private String susMessage;
    private String susDoctorText;
    private long susPayState;

    @TableField(exist = false)
    private SsOperationProject ssObject;

    public long getSusId() {
        return susId;
    }

    public void setSusId(long susId) {
        this.susId = susId;
    }
}
