package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzCardBillMapper;
import cn.gson.hisspring.model.pojos.MzCardBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MzCardBillService {
    @Autowired
    MzCardBillMapper cardBillMapper;

    //新增账单记录表
    public void addMzCardBill(MzCardBill bill){
        cardBillMapper.insert(bill);
    }
}
