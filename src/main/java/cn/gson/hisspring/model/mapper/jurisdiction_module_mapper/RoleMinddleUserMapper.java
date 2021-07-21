package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.RoleMiddleUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface RoleMinddleUserMapper extends BaseMapper<RoleMiddleUser> {
    int upa(@Param("uId") long uId,@Param("rId") long rId);
}
