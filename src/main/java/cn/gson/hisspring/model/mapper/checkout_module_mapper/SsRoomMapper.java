package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.pojos.SsOperationRoom;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//手术室mapper
@Mapper
public interface SsRoomMapper extends BaseMapper<SsOperationRoom> {
  //手术室列表
    List<SsOperationRoom> allSroom();
}
