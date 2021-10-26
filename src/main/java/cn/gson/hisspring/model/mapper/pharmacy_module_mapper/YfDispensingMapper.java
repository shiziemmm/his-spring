package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YfDispensing;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YfDispensingMapper extends BaseMapper<YfDispensing> {
    /**
     * 查询发药记录
     * @param yfDispensing
     */
    List<YfDispensing> allyfdisng(YfDispensing yfDispensing);
}
