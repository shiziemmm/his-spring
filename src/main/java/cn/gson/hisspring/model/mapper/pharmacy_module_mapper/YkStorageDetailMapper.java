package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YkStorageDetail;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * 出库详表mapper
 */
@Mapper
public interface YkStorageDetailMapper extends BaseMapper<YkStorageDetail> {
    //查询全部调拨记录的详细信息
    List<YkStorageDetail> allstoragedetail(Float ykStorageId);
}
