package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinDetailsMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.StopDoctorEnjoinMapper;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoin;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinDetails;
import cn.gson.hisspring.model.pojos.ZyStopDoctorEnjoin;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorEnjoinDetailsService {

    @Autowired
    DoctorEnjoinDetailsMapper dedm;//医嘱详情mapper

    @Autowired
    StopDoctorEnjoinMapper sdem;//停用医嘱mapper

    @Autowired
    DoctorEnjoinMapper dem;//医嘱mapper

    /**
     * 根据住院号查询医嘱详情记录
     * @param ptNo 病人住院号
     * @return
     */
    public List<ZyDoctorEnjoinDetails> doctorEnjoinDetailsSelectByPtId(Long ptNo){

        return dedm.doctorEnjoinDetailsSelectByPtId(ptNo);
    }


    /**
     * 根据住院号查询医嘱详情
     */
    public List<ZyDoctorEnjoinDetails> patientDoctorByPtNo(Long ptNo){
        return dedm.patientDoctorByPtNo(ptNo) ;
    }



}
