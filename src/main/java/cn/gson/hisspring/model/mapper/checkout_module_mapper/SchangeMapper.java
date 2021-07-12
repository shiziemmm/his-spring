package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsChangeAnaesthesia;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

//医疗项目与麻醉中间表
@Mapper
@Repository
public interface SchangeMapper extends BaseMapper<SsChangeAnaesthesia> {

}
