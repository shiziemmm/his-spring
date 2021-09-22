package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzPaymentDetailedMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzPaymentMapper;
import cn.gson.hisspring.model.pojos.MzPayment;
import cn.gson.hisspring.model.pojos.MzPaymentDetailed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 缴费记录表Service
 */
@Service
@Transactional
public class MzPaymentService {
    @Autowired
    MzPaymentMapper paymentMapper;
    @Autowired
    MzPaymentDetailedMapper paymentDetailedMapper;

    /**
     * 新增缴费记录表
     * @param payment
     * @param paymentDetailed
     */


}
