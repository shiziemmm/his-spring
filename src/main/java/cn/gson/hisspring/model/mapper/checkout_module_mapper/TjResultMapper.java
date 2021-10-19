package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.TjCodeProject;
import cn.gson.hisspring.model.pojos.TjManResult;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

//检查结果mapper
@Mapper
public interface TjResultMapper extends BaseMapper<TjManResult> {
    //查询检查结果
    List<TjManResult> allmresult(Integer manId);
    //查询人员是否有结果
    List<TjManResult> sresult(Integer checkId);
    //    批量新增体检套餐与检查项目中间表、
    int insertTjmres(List listArr);
}
