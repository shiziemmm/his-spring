package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YkDruginventory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugStorageMapper {
    /*查询药库的药品库存*/
    List <YkDruginventory> allDrugStorg();
}
