package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyContacts;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsMapper extends BaseMapper<ZyContacts> {
    int insertContactsList(@Param("list") List<ZyContacts> list, @Param("ptNo") Long ptNo);
}
