package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzOpcNumber;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  排号表mapper
  */
@Mapper
public interface MzOpcNumberMapper extends BaseMapper<MzOpcNumber> {
    List<MzOpcNumber> selectMzOpcNumber(long ksName,long science);
}
