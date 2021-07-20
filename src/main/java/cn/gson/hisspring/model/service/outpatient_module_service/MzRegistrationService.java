package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzRegistrationMapper;
import cn.gson.hisspring.model.pojos.MzRegistration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 门诊挂号表 - Service
 */

@Service
@Transactional
public class MzRegistrationService {
    @Autowired
    MzRegistrationMapper mzRegistrationMapper;

    //查询全部或like
    public List<MzRegistration> selectMzRegistration(String like){
        return mzRegistrationMapper.selectMzRegistration(like);
    }

    // 新增挂号表
    public void addReg(MzRegistration mzRegistration){
        mzRegistrationMapper.insert(mzRegistration);
    }

}
