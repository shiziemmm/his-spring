package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YkStorage;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 出库mapper
 */
@Mapper
public interface YKStorageMapper extends BaseMapper<YkStorage> {
    //查询全部的出入库记录
    List<YkStorage>allStorage();
}
