package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data//get  set方法
public class ZyInhospitalApply {

    @TableId("in_id")
    private long inId;
    private Long sickNumber;
    private String inDiagnosis;//诊断结果
    private String inSuggest;//医生建议
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Shanghai")//将数据库的类型返回成指定类型
    private Date inApplyDate;
    private Long ksId;
    private String ksName;
    private String inProposer;
    private Long sId;
    private Long inIs;
    private Long mrNumber;//就诊记录表
    private Long ptNo;//住院号

    //关系
    @TableField(exist = false)
    private MzSick sick;//门诊病人信息对象

    @TableField(exist = false)
    private Staff staff;//员工对象

    public ZyInhospitalApply(long inId, Long inIs, Long ptNo) {
        this.inId = inId;
        this.inIs = inIs;
        this.ptNo = ptNo;
    }

    public ZyInhospitalApply(long inId, Long inIs) {
        this.inId = inId;
        this.inIs = inIs;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public Long getsId() {
        return sId;
    }

    public ZyInhospitalApply() {
    }
}
