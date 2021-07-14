package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyPatientBase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * 住院登记mapper层
 */
@Repository
@Mapper
public interface PatientBaseMapper extends BaseMapper<ZyPatientBase> {

}
