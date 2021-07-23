package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzOpcNumber;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  排号mapper
  */
@Mapper
public interface MzOpcNumberMapper extends BaseMapper<MzOpcNumber> {
    List<MzOpcNumber> selectMzOpcNumber(String ksName,String science);
}
