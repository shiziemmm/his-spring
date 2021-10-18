package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YkDruginventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugStorageMapper extends BaseMapper<YkDruginventory> {
    /*查询药库的药品库存*/
    List<YkDruginventory> allDrugStorg();
    /*药品入库*/
    List<YkDruginventory> putstorage();
}
