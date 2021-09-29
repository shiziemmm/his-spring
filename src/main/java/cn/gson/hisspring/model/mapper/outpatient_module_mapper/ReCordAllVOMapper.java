package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.pojos_vo.ReCordAllVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 包含掉所有的实体类的Vo
 */
@Mapper
public interface ReCordAllVOMapper extends BaseMapper<ReCordAllVO> {
    List<ReCordAllVO> selectAllReCordObject(String index,String texts);
}
