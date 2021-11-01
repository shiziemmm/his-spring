package cn.gson.hisspring.model.mapper.jurisdiction_module_mapper;

import cn.gson.hisspring.model.pojos.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    User login(User user);

    User cha(User us);

    int reset(@Param("upswd") String upswd, @Param("uid") Long uid);
}