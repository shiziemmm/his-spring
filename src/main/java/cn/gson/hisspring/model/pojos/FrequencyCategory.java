package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class FrequencyCategory {
    @TableId(value = "fc_id")
    private long fcId;
    private String fcName;
    private String fcTime;
}
