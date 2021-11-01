package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.FunctionJurisdiction;
import cn.gson.hisspring.model.pojos.Jurisdiction;
import cn.gson.hisspring.model.pojos.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<Role> {
    @Select("select * from role")
    public List<Role> selectAll();

    public List<Role> chaxun();

    public List<FunctionJurisdiction> select();

    public List<Integer> roleFuns(Integer roId);

    public List<FunctionJurisdiction> homeMenu(Integer userId);

    int addRoles(Role role);

    public List<Role> selectStaff();

    public List<Integer> staffFuns(Integer id);

}
