package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationApply;
import cn.gson.hisspring.model.pojos.SsOperationProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//手术申请mapper
@Mapper
public interface SsApplyMapper extends BaseMapper<SsOperationApply> {
    //查询手术申请单
List<SsOperationApply> selectSsApply(String seach);
}
