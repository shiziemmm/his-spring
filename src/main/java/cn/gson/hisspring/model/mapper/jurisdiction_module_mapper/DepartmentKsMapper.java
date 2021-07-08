package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.DepartmentKs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DepartmentKsMapper extends BaseMapper<DepartmentKs> {
    /*
    * 查询部门
    */
    @Select("SELECT * FROM department_ks k , department d WHERE d.de_id =k.de_id")
    List<DepartmentKs> selectlist();
}
