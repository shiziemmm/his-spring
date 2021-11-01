package cn.gson.hisspring.model.pojos.pojos_vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 住院申请 ，门诊患者信息实体类
 */
@Data
public class InHospitalMzVo {

    private Long sickNumber;

    private String sickIdCard;
    private String sickName;
    private String sickPhone;
    private long sickAge;
    private String sickSex;
    private String sickSite;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Shanghai")//将数据库的类型返回成指定类型
    private Date sickTime;
    @TableField(exist = false)//标注这个字段不是数据库字段
    private Long mcNumberCard;//诊疗卡字段

    private Long ksId;//住院科室编号
    private Long sId;//主治医生
    private Long operatorId;//操作员编号

}
