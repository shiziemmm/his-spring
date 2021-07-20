package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalCardMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzRegistrationMapper;
import cn.gson.hisspring.model.pojos.MzCardBill;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
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
    MzRegistrationMapper mzRegistrationMapper;//挂号记录表 mapper

    @Autowired
    MzMedicalCardMapper cardMapper;// 诊疗卡卡号mapper
    @Autowired
    MzCardBillService billService; // 诊疗卡账单记录表 service
    //查询全部或like
    public List<MzRegistration> selectMzRegistration(String like){
        return mzRegistrationMapper.selectMzRegistration(like);
    }

    // 新增挂号表
    public void addReg(MzRegistration mzRegistration){
        //新增挂号记录表
        MzMedicalCard cardObject = mzRegistration.getCardObject();
        mzRegistration.setMcNumber(cardObject.getMcNumber());//新增mc_NUmber
        mzRegistration.setSickNumber(cardObject.getSickNumber());//新镇sick_Number
        mzRegistrationMapper.insert(mzRegistration);
        //修改卡余额
        cardObject.setMcBalance(cardObject.getMcBalance()-mzRegistration.getRtPrice());//扣除卡余额
        cardMapper.updateById(cardObject);
        //新增卡账单记录表
        MzCardBill bill = new MzCardBill();
        bill.setCbCause("门诊挂号");//原因
        bill.setCbPrice(mzRegistration.getRtPrice());//扣费金额
        bill.setSId(mzRegistration.getSId());//操作人员
        bill.setMcNumber(mzRegistration.getCardObject().getMcNumber());//对应卡号
        billService.addMzCardBill(bill);
    }

}
