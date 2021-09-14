package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDrugPharmacyDispensingRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 住院医嘱处方药扣除记录Mapper
 */
@Mapper
public interface DrugPharmacyDispensingRecordMapper extends BaseMapper<ZyDrugPharmacyDispensingRecord> {

}
