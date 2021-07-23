package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.StaffMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医嘱service
 */
@Service
public class DoctorEnjoinService {

    @Autowired
    DoctorEnjoinMapper dem;//医嘱mapper

    @Autowired
    StaffMapper sm;//员工mapper


}
