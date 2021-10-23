package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.pojos_vo.SchedulingVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SchedulingVoMapper extends BaseMapper<SchedulingVo> {
    List<SchedulingVo> chuaxun(Long ksId);
    List<SchedulingVo> selectStaff(@Param("tid") Long tid,@Param("ksId") Long ksId);
}
