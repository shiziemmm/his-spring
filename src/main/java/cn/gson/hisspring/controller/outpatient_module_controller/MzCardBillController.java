package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzPaymentMapper;
import cn.gson.hisspring.model.pojos.MzCardBill;
import cn.gson.hisspring.model.service.outpatient_module_service.MzPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class MzCardBillController {
    @Autowired
    MzPaymentService paymentService;


    @GetMapping("billCard")
    public List<MzCardBill> select(long card){
        return paymentService.select(card);
    };

}
