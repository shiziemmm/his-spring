package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.RoleMiddleJurisdiction;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface RoleMiddleJurisdictionMapper extends BaseMapper<RoleMiddleJurisdiction> {
    int addRoleInfo(Long rId ,List<Integer> funs);


   @Select("select * from role_middle_jurisdiction")
    List<RoleMiddleJurisdiction> seleltAll(long rId);

   @Select("delete from role_middle_jurisdiction where r_id=#{rId}")
    void delet(long rId);
}
