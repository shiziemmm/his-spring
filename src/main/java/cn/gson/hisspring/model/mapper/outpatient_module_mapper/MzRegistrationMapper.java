package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzRegistration;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  门诊挂号表 - mapper
 */

@Mapper
public interface MzRegistrationMapper extends BaseMapper<MzRegistration> {
    //查询全部或like
    public List<MzRegistration> selectMzRegistration(String like);
}
