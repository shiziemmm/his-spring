package cn.gson.hisspring.model.mapper.inhospital_module_mapper;


import cn.gson.hisspring.model.pojos.ZyWard;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 病房mapper层
 */
@Mapper
@Repository
public interface WardMapper extends BaseMapper<ZyWard> {

    List<ZyWard> selectWardAllPage();


}
