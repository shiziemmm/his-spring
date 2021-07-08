package cn.gson.hisspring.model.mapper.checkout_module_mapper;


import cn.gson.hisspring.model.pojos.SsOperationAnaesthesia;
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
    //查询所有手术项目
    @Select("SELECT * FROM ss_operation_project a inner join department_ks k where a.ks_id=k.ks_id")
    List<SsOperationProject> allProject();
    //查询所有手术项目
    @Select("SELECT * FROM ss_operation_project a inner join department_ks k where a.ks_id=k.ks_id and project_id=#{projectId}")
    List<SsOperationProject> singleProject(Integer projectId );

}
