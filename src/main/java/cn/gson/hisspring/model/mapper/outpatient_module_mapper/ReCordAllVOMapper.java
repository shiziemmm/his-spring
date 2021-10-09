package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzRecipe;
import cn.gson.hisspring.model.pojos.MzSurgeryStamp;
import cn.gson.hisspring.model.pojos.TjCodeMan;
import cn.gson.hisspring.model.pojos.pojos_vo.ReCordAllVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 包含掉所有的实体类的Vo
 */
@Mapper
public interface ReCordAllVOMapper extends BaseMapper<ReCordAllVO> {

    //vo 所有查询
    List<ReCordAllVO> selectAllReCordObject(String index,String texts);

    //    处方单项对应查询
    List<MzRecipe> selectAllReCordOrDrug(Long recipeNumber);
    //    体检单项对应查询
    List<TjCodeMan> selectAllReCordOrTj(Long susNumber);
    //    手术单项对应查询
    List<MzSurgeryStamp> selectAllReCordOrSs(Long manId);
}
