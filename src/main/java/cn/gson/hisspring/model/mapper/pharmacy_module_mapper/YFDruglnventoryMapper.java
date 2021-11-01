package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YfDruginventory;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YFDruglnventoryMapper extends BaseMapper<YfDruginventory> {
    /*查询药品药房库存*/
    List<YfDruginventory> allYFlnventory();
}
