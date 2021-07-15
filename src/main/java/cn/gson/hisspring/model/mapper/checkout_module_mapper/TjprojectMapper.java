package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.TjCodeProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
检查项目mapper
 */
@Mapper
@Repository
public interface TjprojectMapper extends BaseMapper<TjCodeProject> {
    List<TjCodeProject> selectAllTjObject(String seach);
}