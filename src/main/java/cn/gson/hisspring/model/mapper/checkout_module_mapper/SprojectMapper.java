package cn.gson.hisspring.model.mapper.checkout_module_mapper;


import cn.gson.hisspring.model.pojos.SsOperationProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
/**
 * 手术项目mapper层
 */
@Mapper
public interface SprojectMapper extends BaseMapper<SsOperationProject> {
    @Select("SELECT * FROM ss_operation_project")
    List<SsOperationProject> allProject();
}
