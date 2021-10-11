package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.InHospitalApplyMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.*;
import cn.gson.hisspring.model.pojos.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 门诊问诊操作
 */
@Service
@Transactional
public class MzOpcService {
    @Autowired
    MzMedicalRecordMapper medicalRecordMapper; //就诊记录mapper
    @Autowired
    MzOpcNumberMapper opcNumberMapper;//排号
    @Autowired
    MzOpcNumberService opcNumberService;//排号Service

    @Autowired
    MzCaseHistoryMapper historyMapper;//病历表


    @Autowired
    MzPaymentMapper paymentMapper;  // 缴费记录表

    @Autowired
    InHospitalApplyMapper inHospitalApplyMapper;//住院申请

    @Autowired
    DepartmentKsMapper departmentKsMapper;//科室mapper

    /**
     * 添加住院申请
     * @param inhospitalApply
     */
    public void addInHospitalApply(ZyInhospitalApply inhospitalApply,String rtNumber){
        //修改排号状态
        opcNumberService.upRtNumber(rtNumber);
        inhospitalApply.setInIs(0L);
        QueryWrapper qw = new QueryWrapper();
        qw.eq("rt_Number",rtNumber);
        MzOpcNumber opcNumber = opcNumberMapper.selectOne(qw);
        opcNumber.setBnState(1);
        opcNumberMapper.updateById(opcNumber);
        inHospitalApplyMapper.insert(inhospitalApply);
    }

    /**
     * 住院申请查询所有的科室
     * @return
     */
    public List<DepartmentKs> selectKs(Integer index){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("de_id",index);
        List<DepartmentKs> list = departmentKsMapper.selectList(qw);
        return list;
    }
    /**
     * 病例表查询
     */
    public List<MzCaseHistory> selectCaseHistory(Integer index){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("sick_Number",index);
        List<MzCaseHistory> list = historyMapper.selectList(qw);
        return list;
    }

}
