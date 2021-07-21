package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzMcRecharge;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 门诊充值纪录表-mapper
 */

@Mapper
public interface MzMcRechargeMapper extends BaseMapper<MzMcRecharge> {
    //连表查询
    List<MzMcRecharge> selectMzMcRecharge(String like);
}
