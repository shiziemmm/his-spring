package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzXprescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  西药处方
 */
@Mapper
public interface MzXprescriptionMapper extends BaseMapper<MzXprescription> {
    // 新增处方单
    public void addListXp(List<MzXprescription> Xpist);
}
