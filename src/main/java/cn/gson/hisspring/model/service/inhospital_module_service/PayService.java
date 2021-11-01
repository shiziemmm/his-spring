package cn.gson.hisspring.model.service.inhospital_module_service;


import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PayMapper;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import cn.gson.hisspring.model.pojos.ZyPay;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;


/**
 * 住院缴费service
 */
@Service
@Transactional
public class PayService {

    @Autowired
    PayMapper pm;//住院缴费mapper

    @Autowired
    PatientBaseMapper pbm;//住院登记mapper

    /**
     * 根据住院号查询病人缴费金额
     */
    public Double selectPayByPtNoPrice(Long ptNo) {
        return pm.selectPayByPtNoPrice(ptNo);
    }


    /**
     * 新增缴费记录
     * 根据住院编号修改病人账户余额
     *
     * @param pay
     * @return
     */
    public boolean addPay(ZyPay pay) {
        //新增缴费记录
        pay.setPyDate(new Timestamp(new Date().getTime()));//设置为当前时间
        pm.insert(pay);//新增

        //==================根据住院编号修改病人账户余额

        //先根据病人住院号查询病人住院登记信息
        ZyPatientBase pb = pbm.selectById(pay.getPtNo());

        ZyPatientBase pbs = new ZyPatientBase(pay.getPtNo(), pb.getPtPayMoney() + pay.getPyPrice(), pb.getPtPrice() + pay.getPyPrice());
        int i = pbm.updateById(pbs);//修改

        if (i > 0)
            return true;
        return false;
    }

    /**
     * 根据病人住院号查询病人缴费记录
     */
    public List<ZyPay> selectPayByPtNo(Long ptNo, SelectExecuteVo selectExecuteVo) {
        return pm.selectPayByPtNo(ptNo, selectExecuteVo.getStartDate(), selectExecuteVo.getEndDate(), selectExecuteVo.getSIdArr());
    }

    /**
     * 根据住院号查询出所有操作人员信息
     */
    public List<Staff> selectByPtNoStaff(Long ptNo) {
        return pm.selectByPtNoStaff(ptNo);
    }

}
