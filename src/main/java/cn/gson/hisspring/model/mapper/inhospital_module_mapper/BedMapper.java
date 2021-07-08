package cn.gson.hisspring.model.mapper.inhospital_module_mapper;


import cn.gson.hisspring.model.pojos.ZyBed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * 病床mapper层
 */
@Mapper
@Repository
public interface BedMapper extends BaseMapper<ZyBed> {

}
