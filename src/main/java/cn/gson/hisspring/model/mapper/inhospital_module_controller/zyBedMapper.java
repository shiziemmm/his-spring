package cn.gson.hisspring.model.mapper.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.ZyBed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//代表持久层
@Mapper
public interface zyBedMapper extends BaseMapper<ZyBed> {

   List<ZyBed> selectAllZyBed(Page page);
}
