package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.pojos.TjCodeIndex;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 检查项目指标mapper层
 */
@Mapper
public interface TjIndexMapper extends BaseMapper<TjCodeIndex> {
    //查询所有指标项目
    @Select("SELECT * FROM tj_code_index")
    List<TjCodeIndex> allIndex();

}
