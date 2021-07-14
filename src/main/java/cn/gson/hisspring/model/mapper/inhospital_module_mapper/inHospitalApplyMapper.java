package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyInhospitalApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 住院申请mapper层
 */
@Mapper
@Repository
public interface inHospitalApplyMapper extends BaseMapper<ZyInhospitalApply> {

}
