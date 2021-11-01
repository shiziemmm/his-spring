package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzAlterLose;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 门诊-挂失补卡修改记录表mapper
 */
@Mapper
public interface MzAlterLoseMapper extends BaseMapper<MzAlterLose> {
    /**
     * 连表查询
     */
    List<MzAlterLose> selectMzAlterLose(String mzSickTest);
}
