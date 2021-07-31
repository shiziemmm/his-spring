package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzZprescription;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 中药处方-mapper
 */
@Mapper
public interface MzZprescriptionMapper extends BaseMapper<MzZprescription> {
    // 新增处方单
    public void addListZp(List<MzZprescription> zpList);
}
