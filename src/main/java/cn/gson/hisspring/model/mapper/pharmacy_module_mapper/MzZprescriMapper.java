package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.MzZprescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MzZprescriMapper extends BaseMapper<MzZprescription> {
    //查询门诊中药需要发的药品
    List<MzZprescription>allMzzy(Long recipeNumber);
}
