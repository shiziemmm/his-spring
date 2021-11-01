package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.TjManResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 检验申请表
 */
@Mapper
public interface MzTjManResultMapper extends BaseMapper<TjManResult> {
    /**
     * 循环检验表添加
     */
    public void addTjManResultArr(@Param("list") List<TjManResult> list);
}
