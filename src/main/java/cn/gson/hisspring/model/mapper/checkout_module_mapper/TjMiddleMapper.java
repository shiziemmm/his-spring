package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.TjCodeMiddle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

/**
 * 体检套餐中间表mapper层
 */
@Mapper
public interface TjMiddleMapper extends BaseMapper<TjCodeMiddle> {
    @Delete("delete from tj_code_middle where code_id=#{codeId}")
    public void delete(Integer codeId);
}
