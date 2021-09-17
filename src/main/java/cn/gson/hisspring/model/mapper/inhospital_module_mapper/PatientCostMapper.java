package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.pojos_vo.PatientCostVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 病人费用明细mapper
 */
@Mapper
public interface PatientCostMapper extends BaseMapper<PatientCostVo> {

}
