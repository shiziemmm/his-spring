package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzCardBillMapper;
import cn.gson.hisspring.model.pojos.MzCardBill;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 账单流水表 -service
 */
@Service
@Transactional
public class MzCardBillService {
    @Autowired
    MzCardBillMapper cardBillMapper;

    //新增账单记录表
    public void addMzCardBill(MzCardBill bill){
        cardBillMapper.insert(bill);
    }

    public List<MzCardBill> selectCardBill(long card){
        return cardBillMapper.cardBillSe(card);
    };
}
