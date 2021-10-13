package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.MzXprescription;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MzXprescriMapper {
    //查询门诊西药需要发的药品
    List<MzXprescription> allmzxy();
}
