package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDischarge;
import cn.gson.hisspring.model.pojos.ZyDischargeApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * 病人申请出院mapper
 */
@Repository
public interface DischargeApplyMapper extends BaseMapper<ZyDischargeApply> {

}
