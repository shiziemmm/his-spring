package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * 医嘱详表mapper
 */
@Repository
public interface DoctorEnjoinDetailsMapper extends BaseMapper<ZyDoctorEnjoinDetails> {


    int insertDeDetailsFor(@Param("dedList") List<ZyDoctorEnjoinDetails> doctorEnjoinDetails, @Param("deId") Long deId,@Param("DesExecuteDate") Timestamp date);

    int updateDesByDeIdOrDesId(@Param("desId") Long desId,@Param("deId") Long deId);
}
