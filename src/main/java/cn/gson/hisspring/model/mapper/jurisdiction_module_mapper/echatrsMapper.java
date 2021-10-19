package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.pojos_vo.echartsVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface echatrsMapper {

    List<echartsVo> getAllEcharts();
    List<echartsVo> getList();
}
