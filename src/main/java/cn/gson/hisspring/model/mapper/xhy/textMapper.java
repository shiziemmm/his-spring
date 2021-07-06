package cn.gson.hisspring.model.mapper.xhy;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface textMapper {

    @Select("select py_price from zy_pay")
    String selectString();
}
