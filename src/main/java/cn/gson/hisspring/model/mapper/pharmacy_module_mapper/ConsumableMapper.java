package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.HcIndConsumables;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ConsumableMapper {
    //查询耗材信息
    List<HcIndConsumables> allConsumables();

    //新增耗材
    void addConsumables(HcIndConsumables hcIndConsumables);

    //修改耗材
    void updateConsumables(HcIndConsumables hcIndConsumables);
}
