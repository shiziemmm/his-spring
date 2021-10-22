package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzPaymentMapper;
import cn.gson.hisspring.model.pojos.MzCardBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 缴费记录表Service
 */
@Service
@Transactional
public class MzPaymentService {
    @Autowired
    MzPaymentMapper paymentMapper;
    @Autowired
    MzCardBillService billService;


    public List<MzCardBill> select(long card){
        return billService.selectCardBill(card);
    };

}
