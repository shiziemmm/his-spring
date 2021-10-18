package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.pojos_vo.PatientCostVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 病人费用明细mapper
 */
@Mapper
public interface PatientCostMapper extends BaseMapper<PatientCostVo> {

    List<PatientCostVo> selectPayAll(@Param("ptNo") Long ptNo, @Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("sIdArr") List<Long> sId);

    List<PatientCostVo> selectPayByWhere(@Param("ptNo") Long ptNo, @Param("text") String text, @Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("sIdArr") List<Long> sId);

    List<PatientCostVo> selectPayByWhereDischarge(@Param("ptNo") Long ptNo, @Param("text") String text, @Param("startDate") Date startDate,@Param("endDate") Date endDate,@Param("sIdArr") List<Long> sId);
}
