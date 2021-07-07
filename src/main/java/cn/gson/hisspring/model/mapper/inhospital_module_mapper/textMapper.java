package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyPay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository//代表持久层
@Mapper
public interface textMapper extends BaseMapper<ZyPay> {

    List<ZyPay> selectString(Integer id);

}
