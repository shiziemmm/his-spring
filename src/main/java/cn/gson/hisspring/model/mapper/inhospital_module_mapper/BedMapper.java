package cn.gson.hisspring.model.mapper.inhospital_module_mapper;


import cn.gson.hisspring.model.pojos.ZyBed;
import cn.gson.hisspring.model.service.inhospital_module_service.BedService;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 * 病床mapper层
 */
@Mapper
@Repository
public interface BedMapper extends BaseMapper<ZyBed> {

}
