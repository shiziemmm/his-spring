package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YfDruginformation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugInformation_Mapper {
    //查询药品信息
    List <YfDruginformation> queryById();
}
