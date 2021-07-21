package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationAnaesthesia;
import cn.gson.hisspring.model.pojos.TjCodeType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*
体检类型mapper
 */
@Mapper
public interface TJTypeMapper extends BaseMapper<TjCodeType> {
    @Select("SELECT * FROM tj_code_type")
    List<TjCodeType> alltype();
}
