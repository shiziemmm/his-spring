package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.Scheduling;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SchedulingMapper extends BaseMapper<Scheduling> {
    int addSch(@Param("sd") Scheduling sd,@Param("list") List<Integer> list);
    List<Scheduling> selectAll(@Param("scDate") String star,@Param("scEnd") String end);
}
