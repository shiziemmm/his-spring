package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.TjCodeMeal;
import cn.gson.hisspring.model.pojos.TjCodeProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
/**
 * 体检套餐mapper层
 */
@Mapper
public interface TjmealMapper extends BaseMapper<TjCodeMeal> {
    List<TjCodeMeal> selectAllTjMeal(String checkIndex,String codeName,String codeType);
//    批量新增体检套餐与检查项目中间表、
    int insertTjmid(List<Integer> listArr,long codeId);
}
