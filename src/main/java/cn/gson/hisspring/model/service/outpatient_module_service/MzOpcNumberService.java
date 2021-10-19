package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.TitleMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzDepartmentKsMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzOpcNumberMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzRegistrationMapper;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import cn.gson.hisspring.model.pojos.MzOpcNumber;
import cn.gson.hisspring.model.pojos.MzRegistration;
import cn.gson.hisspring.model.pojos.Title;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 排号表Service
 */
@Service
@Transactional
public class MzOpcNumberService {
    @Autowired
    MzOpcNumberMapper countMapper; // 排号表mapper
    @Autowired
    MzDepartmentKsMapper ksMapper; //科室mapper
    @Autowired
    TitleMapper titleMapper; //职称表mapper
    @Autowired
    MzRegistrationService registrationService;//挂号表service
    @Autowired
    MzRegistrationMapper mzRegistrationMapper;//挂号记录表 mapper


    //排号列表查询
    public List<MzOpcNumber> selectMzOpcNumber(long ksName,long science){
        //查询科室
        List<MzOpcNumber> mzOpcNumbers = countMapper.selectMzOpcNumber(ksName,science);
        return mzOpcNumbers;
    }
    // 过号
    public void jumpMark(MzOpcNumber opcNumber){
        Long aLong = registrationService.maxCount(opcNumber.getKsId(), opcNumber.getBnScience(), opcNumber.getBnTime());
        opcNumber.setBnCount(aLong+1);
        countMapper.updateById(opcNumber);//修改掉他的卡号
    }
    //删除排号
//    public void delecteOpcCount(Long bnNumber){
//        QueryWrapper qw = new QueryWrapper();
//        qw.eq("bn_number",bnNumber);
//        countMapper.delete(qw);
//    }
    //修改挂号表状态
    public void  upRtNumber(String rtNumber ){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("rt_number",rtNumber);
        MzRegistration mzRegistration = mzRegistrationMapper.selectOne(qw);
        mzRegistration.setRtState(1);
        mzRegistrationMapper.updateById(mzRegistration);
    }

}
