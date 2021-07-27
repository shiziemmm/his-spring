package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.DepartmentKs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DepartmentKsMapper extends BaseMapper<DepartmentKs> {
    /*
    * 查询部门
    */

    List<DepartmentKs> selectlist();

    /**
     * 根据住院部查询科室
     */
    List<DepartmentKs> selectZyKs();
    List<DepartmentKs> selectId(Long id);
    List<DepartmentKs>selectName();
    List<DepartmentKs> selectdome(DepartmentKs departmentKs);

}
