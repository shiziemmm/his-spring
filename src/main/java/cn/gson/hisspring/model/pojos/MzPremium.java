package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * 门诊-退费记录表pojos
 */

@Data//get  set方法
public class MzPremium {
    @TableId(type = IdType.AUTO)
    private long premiumNumbe;
    private String premiumName;
    private String premiumCause;
    private double premiumPrice;
    private Date premiumTime;
    private long sId;
    private long mcNumberCard;
    private String sickNumber;


}
