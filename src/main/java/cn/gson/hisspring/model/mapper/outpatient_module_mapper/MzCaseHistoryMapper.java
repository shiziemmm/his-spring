package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzCaseHistory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 病历表
 */
@Mapper
public interface MzCaseHistoryMapper extends BaseMapper<MzCaseHistory> {

}
