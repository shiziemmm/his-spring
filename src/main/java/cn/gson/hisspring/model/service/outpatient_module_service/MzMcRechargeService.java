package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMcRechargeMapper;
import cn.gson.hisspring.model.pojos.MzMcRecharge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 *  充值记录-
 */

@Service
public class MzMcRechargeService {
    @Autowired
    MzMcRechargeMapper rechargeMapper;

    //查询所有充值记录表，和laik查询
    public List<MzMcRecharge> allLikeMzMcRecharge(String like){
        List<MzMcRecharge> mzMcRecharges = rechargeMapper.selectMzMcRecharge(like);
        return mzMcRecharges;
    }



}
