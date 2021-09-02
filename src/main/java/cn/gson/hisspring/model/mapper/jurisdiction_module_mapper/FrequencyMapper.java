package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.Frequency;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface FrequencyMapper extends BaseMapper<Frequency> {
    List<Frequency> selectById(long fid);
    int updateById(Frequency frequency);
    List<Frequency> selectAllId(long fcId);
  List<Frequency> selectAll();
    void addRoleInfo(@Param("mapList")List<Map> mapList, @Param("fcId") Integer fcId);
}
