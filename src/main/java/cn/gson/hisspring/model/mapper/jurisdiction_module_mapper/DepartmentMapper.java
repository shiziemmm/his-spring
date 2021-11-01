package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.Department;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface DepartmentMapper extends BaseMapper<Department> {
    List<Department> selectlike(Department dept);

    int add(String deName);

}
