package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import cn.gson.hisspring.model.pojos.ZyStopDoctorEnjoin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 医嘱停用mapper
 */
@Repository
public interface StopDoctorEnjoinMapper extends BaseMapper<ZyStopDoctorEnjoin> {
    int insertStopDoctorEnjoinFor(@Param("dedList")List<ZyDoctorEnjoinDetails> dedList,@Param("sde") ZyStopDoctorEnjoin sde);
}
