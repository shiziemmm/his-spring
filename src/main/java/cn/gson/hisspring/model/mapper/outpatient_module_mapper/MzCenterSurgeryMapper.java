package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzCenterSurgery;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *  手术中间表集合mapper
 */
@Mapper
public interface MzCenterSurgeryMapper extends BaseMapper<MzCenterSurgery> {
    /*循环添加手术集合表*/
    public void addCenterSurgery (List<MzCenterSurgery> list);
}
