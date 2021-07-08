package cn.gson.hisspring.model.pojos;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
/**
 * 门诊-病人资资料表
 */

@Data//get  set方法
public class MzSick {
  @TableId(type = IdType.ASSIGN_UUID)
  private String sickNumber;
  private String sickIdCard;
  private String sickName;
  private String sickPhone;
  private long sickAge;
  private String sickSex;
  private String sickSite;
  private Date sickTime;
}
