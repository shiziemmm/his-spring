package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDischarge;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 住院记录
 */
@Mapper
public interface DischargeMapper extends BaseMapper<ZyDischarge> {
    List<ZyDischarge> selectDischargeAll(SelectExecuteVo selectExecuteVo);
}
