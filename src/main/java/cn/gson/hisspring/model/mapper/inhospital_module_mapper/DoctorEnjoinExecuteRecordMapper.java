package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinExecuteRecord;
import cn.gson.hisspring.model.pojos.pojos_vo.DispensingVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorEnjoinExecuteRecordMapper extends BaseMapper<ZyDoctorEnjoinExecuteRecord> {
    List<ZyDoctorEnjoinExecuteRecord> selectExecutePharmacyByKsIdOrDrugId(DispensingVo dispensingVo);

    int updateDoctorExecuteIs(List<ZyDoctorEnjoinExecuteRecord> zyDoctorEnjoinExecuteRecord);

    List<ZyDoctorEnjoinExecuteRecord> selectExecuteDoctor(SelectExecuteVo selectExecuteVo);
}
