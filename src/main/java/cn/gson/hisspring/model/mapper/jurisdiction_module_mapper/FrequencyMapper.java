package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.Frequency;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FrequencyMapper extends BaseMapper<Frequency> {
    List<Frequency> selectById(long fid);


    int updateById(long fid);
}
