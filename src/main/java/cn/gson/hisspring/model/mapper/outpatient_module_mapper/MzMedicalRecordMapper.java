package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzMedicalRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 就诊记录表
 */

@Mapper
public interface MzMedicalRecordMapper extends BaseMapper<MzMedicalRecord> {
    //查询就诊记录表
    List<MzMedicalRecord> selectMzMedicalRecord(String index,String texts);
    //查询就诊记录表 -- 缴费查询
    MzMedicalRecord selectMzMedicalRecords(String texts);
}
