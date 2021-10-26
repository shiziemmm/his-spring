package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzMedicalCard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 门诊-诊疗卡mapper
 */

@Mapper
public interface MzMedicalCardMapper extends BaseMapper<MzMedicalCard> {
    //连表查询门诊病人资料可就诊卡
    List<MzMedicalCard> selectAllMzMedicalCard(String mzSickTest);
    MzMedicalCard selectAllMzMedicalCard2(String card);
    //查询单个卡号
    MzMedicalCard selectByIdObject(String mcCard);
}
