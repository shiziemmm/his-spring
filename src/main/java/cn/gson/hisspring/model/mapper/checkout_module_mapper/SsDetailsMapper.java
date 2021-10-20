package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationDetails;
import cn.gson.hisspring.model.pojos.SsOperationRoom;
import cn.gson.hisspring.model.pojos.TjCodeMan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

//手术记录mapper
@Mapper
public interface SsDetailsMapper  extends BaseMapper<SsOperationDetails> {
    //查询手术记录
    List<SsOperationDetails> selectAllsDetails(String seach);
    //查询单手术记录
    List<SsOperationDetails> selectAloneDetails(Integer operationNum);
    //根据手术id查记录
    @Select("select * from ss_operation_details  where project_id=#{projectId}")
    List<SsOperationDetails> selectDat(Integer projectId);
}
