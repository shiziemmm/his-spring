package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.MzRecipe;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface YfMzRecipeMapper extends BaseMapper<MzRecipe> {
    //查询已经缴费的处方单
    List<MzRecipe> allMzRecipess();
}
