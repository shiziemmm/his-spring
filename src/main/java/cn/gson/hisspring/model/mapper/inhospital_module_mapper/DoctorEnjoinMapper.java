package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 医嘱mapper
 */
@Repository
public interface DoctorEnjoinMapper extends BaseMapper<ZyDoctorEnjoin> {

    List<ZyDoctorEnjoin> doctorEnjoinSelectByPtId(Long ptNo);

}
