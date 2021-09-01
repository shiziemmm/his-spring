package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDeptDrugAllot;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 科室库存调拨记录mapper
 */
@Mapper
public interface DeptDrugAllotMapper extends BaseMapper<ZyDeptDrugAllot> {

    int addDeptDrugAllotList(List<ZyDeptDrugAllot> list);

    List<ZyDeptDrugAllot> selectByKsId(Long ksId);

}
