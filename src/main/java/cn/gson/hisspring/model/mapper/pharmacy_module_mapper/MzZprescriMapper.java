package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.MzZprescription;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MzZprescriMapper {
    //查询门诊中药需要发的药品
    List<MzZprescription>allMzzy();
}
