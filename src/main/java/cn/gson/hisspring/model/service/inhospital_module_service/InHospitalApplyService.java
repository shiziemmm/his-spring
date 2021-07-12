package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.inHospitalApplyMapper;
import cn.gson.hisspring.model.pojos.ZyInhospitalApply;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class InHospitalApplyService {

    @Autowired
    inHospitalApplyMapper has;

    public List<ZyInhospitalApply> selectHspApply(){
        QueryWrapper<ZyInhospitalApply> qw = new QueryWrapper<>();
        qw.eq("in_is",1);//查询为审核的住院申请1是未审核
        List<ZyInhospitalApply> list = has.selectList(qw);
        return list.isEmpty() ? null : list;
    }
}
