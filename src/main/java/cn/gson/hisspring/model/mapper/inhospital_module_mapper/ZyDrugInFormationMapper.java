package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.pojos_vo.DrugSearchVo;
import cn.gson.hisspring.model.pojos.pojos_vo.DrugVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface ZyDrugInFormationMapper extends BaseMapper<DrugVo> {

    List<DrugVo> selectDrugByDrugName(DrugSearchVo search);

    List<Object> selectDrugUnit();

    List<Object> selectDrugUsage();
}
