package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalCardMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzOpcNumberMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzRegistrationMapper;
import cn.gson.hisspring.model.pojos.MzCardBill;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.MzOpcNumber;
import cn.gson.hisspring.model.pojos.MzRegistration;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
    MzOpcNumberMapper opcNumberMapper;//排号id
    @Autowired
    MzMedicalCardService cardService;//诊疗卡service
    @Autowired
    MzMedicalCardMapper cardMapper;// 诊疗卡卡号mapper
    @Autowired
    MzCardBillService billService; // 诊疗卡账单记录表 service
    //查询全部或like或者点击当天和预约
    public List<MzRegistration> selectMzRegistration(String reg,Integer index ,String dates){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Calendar c = Calendar.getInstance();
        if(index != null && index !=0){
            dates= sf.format(c.getTime());
            System.err.println("当前日期:"+sf.format(c.getTime()));
        }
        List<MzRegistration> mzRegistrations = mzRegistrationMapper.selectMzRegistration(reg, index, dates);
        for (MzRegistration mzRegistration : mzRegistrations) {
            if(sf.format(mzRegistration.getRtOnsetTime()).equals(sf.format(c.getTime()) )){//如果查询到的是时间和当前系统时间对应那就改它type
                mzRegistration.setRtType("当天挂号");
                mzRegistrationMapper.updateById(mzRegistration);
            }
        }
        return mzRegistrations;
    }
    // 新增挂号表
    public void addReg(MzRegistration mzRegistration){
        //新增挂号记录表
        mzRegistration.setRtState(0);//0为进行中，未完成
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

        //挂号时就得生成排号单
        MzOpcNumber opcNumber = new MzOpcNumber();
        opcNumber.setBnTime(mzRegistration.getRtOnsetTime());//排号时间
        opcNumber.setMrNumber(null);
        opcNumber.setRtNumber(mzRegistration.getRtNumber());
        opcNumber.setBnIdCard(cardObject.getMcIdCard());
        opcNumber.setBnKsName(mzRegistration.getRtOverKsName());
        opcNumber.setBnSickName(cardObject.getMzSick().getSickName());
        opcNumber.setBnState(0L);
        opcNumber.setBnScience(mzRegistration.getRtScience());
        //日期格式来加个判断
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Calendar c = Calendar.getInstance();
        //查询当前科室的挂号人数，来生成排号号码
        QueryWrapper<MzOpcNumber> wp = new QueryWrapper<>();//我这次新增的科室，查询科室后面生成号码
        wp.eq("bn_ks_name",mzRegistration.getRtOverKsName());
        wp.eq("bn_science",mzRegistration.getRtScience());
        wp.eq("date_format(bn_time ,'%Y-%m-%d')",sf.format(mzRegistration.getRtOnsetTime()));// 日期
        System.err.println(sf.format(c.getTime())+"==111111111111111111111111111111111111111111111");
        List<MzOpcNumber> opcCount = opcNumberMapper.selectList(wp);
        if(opcCount.isEmpty()){//如果他是第一个就1
            opcNumber.setBnCount(1L);
        }else{//不是就号码加1
            opcNumber.setBnCount(maxCount(mzRegistration.getRtOverKsName(),mzRegistration.getRtScience(),mzRegistration.getRtOnsetTime())+1);
        }
        opcNumberMapper.insert(opcNumber);
    }
    //返回数据库最大值--科室排号
    public Long maxCount(String ksName ,String science,Date date){
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
        Calendar c = Calendar.getInstance();
        //按区间分号，排号
        QueryWrapper<MzOpcNumber> wp = new QueryWrapper<>();
        wp.eq("bn_ks_name",ksName);// 科室
        wp.eq("bn_science",science);// 医生职称
        wp.eq("date_format(bn_time ,'%Y-%m-%d')",sf.format(date));// 日期
        wp.orderByDesc("bn_count").last("limit 1");
        MzOpcNumber opcCount = opcNumberMapper.selectOne(wp);
        return  opcCount.getBnCount();
    }


}
