package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinExecuteRecord;
import cn.gson.hisspring.model.pojos.ZyDrugPharmacy;
import cn.gson.hisspring.model.pojos.pojos_vo.DispensingVo;
import cn.gson.hisspring.model.pojos.pojos_vo.PharmacyVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 科室药房mapper
 */
@Mapper
public interface DrugPharmacyMapper extends BaseMapper<ZyDrugPharmacy> {

    List<PharmacyVo> selectPharmacyByKsOrAll(Long ksId);

    List<PharmacyVo> selectPharmacyByKsIdOrDrugId(DispensingVo dispensingVo);


}
