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
    List<DepartmentKs> selectId(Long id);
    List<DepartmentKs>selectName();
}
