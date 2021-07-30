package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalRecordMapper;
import cn.gson.hisspring.model.pojos.MzMedicalRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 就诊记录表 service
 */

@Service
@Transactional
public class MzMedicalRecordService {
    @Autowired
    MzMedicalRecordMapper medicalRecordMapper; //就诊记录mapper

    /**
     * 添加就诊记录表
     */
    public void addMedicalRecord(MzMedicalRecord medicalRecord){
        medicalRecordMapper.insert(medicalRecord);
    }

    /**
     *  查询就诊记录表
     */
    public void selectMedicalRecord(Long index){
        medicalRecordMapper.selectMzMedicalRecord(index);
    }
}
