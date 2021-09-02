package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationDetails;
import cn.gson.hisspring.model.pojos.SsOperationRoom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

//手术记录mapper
@Mapper
public interface SsDetailsMapper  extends BaseMapper<SsOperationDetails> {
}
