package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDischarge;
import cn.gson.hisspring.model.pojos.ZyDischargeApply;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientCostVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 病人申请出院mapper
 */
@Repository
public interface DischargeApplyMapper extends BaseMapper<ZyDischargeApply> {

    List<ZyDischargeApply> selectDischargeApplyAll(String search);

    List<PatientCostVo> costDischargeAllByPtNo(@Param("ptNo") Long ptNo,@Param("text") String text);

}
