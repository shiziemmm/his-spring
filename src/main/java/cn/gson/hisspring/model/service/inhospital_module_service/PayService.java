package cn.gson.hisspring.model.service.inhospital_module_service;


import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PayMapper;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import cn.gson.hisspring.model.pojos.ZyPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;


/**
 * 住院缴费service
 */
@Service
@Transactional
public class PayService{

    @Autowired
    PayMapper pm;//住院缴费mapper

    @Autowired
    PatientBaseMapper pbm;//住院登记mapper


    /**
     * 新增缴费记录
     * 根据住院编号修改病人账户余额
     * @param pay
     * @return
     */
    public boolean addPay(ZyPay pay){
        //新增缴费记录
        pay.setPyDate(new Timestamp(new Date().getTime()));//设置为当前时间
        pm.insert(pay);//新增

        //==================根据住院编号修改病人账户余额

        //先根据病人住院号查询病人住院登记信息
        ZyPatientBase pb = pbm.selectById(pay.getPtNo());

        ZyPatientBase pbs = new ZyPatientBase(pay.getPtNo(),pb.getPtPayMoney()+pay.getPyPrice(),pb.getPtPrice()+pay.getPyPrice());
        pbm.updateById(pbs);//修改


        return false;
    }
}
