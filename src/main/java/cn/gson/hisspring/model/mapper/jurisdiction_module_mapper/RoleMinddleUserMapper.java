package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.RoleMiddleJurisdiction;
import cn.gson.hisspring.model.pojos.RoleMiddleUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMinddleUserMapper extends BaseMapper<RoleMiddleUser> {
    int upa(@Param("uId") long uId, @Param("rId") long rId);

    @Select("select * from role_middle_user where u_id=#{uId}")
    List<RoleMiddleUser> dome(long rId);

    @Select("delete from role_middle_user where u_id=#{uId}")
    void delet(long uId);

    int addStaff(Long uId, List<Integer> funs);

    List<RoleMiddleUser> select(Integer uId);
}
