package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DischargeApplyMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.pojos.ZyDischarge;
import cn.gson.hisspring.model.pojos.ZyDischargeApply;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


/**
 * 病人申请出院service
 */
@Service
@Transactional
public class DischargeApplyService {

    @Autowired
    DischargeApplyMapper dam;//住院申请mapper

    @Autowired
    PatientBaseMapper pbm;//住院登记mapper


    /**
     *添加病人申请
     * @return 放回错误信息
     */
    public String addDischargeApply(ZyDischargeApply zyDischarge){
        String err = "";//错误提示
        zyDischarge.setDgaIs("1");

        //==========================判断医嘱是否全部执行完成

//        if(true){
//            return "药品未领取";
//        }

        //======================判断是否有手术



        //================修改病人住院信息为申请出院中
        ZyPatientBase zpb = new ZyPatientBase();
        zpb.setPtNo(zyDischarge.getPtNo());
        zpb.setPtIs(2L);
        pbm.updateById(zpb);//修改状态

        //===================如果走到这里就说明可以申请出院
        dam.insert(zyDischarge);//新增住院申请

        return "yes";
    }


    /**
     * 取消申请出院
     * @param ptNo
     * @param cause
     * @return
     */
    public boolean callPatientApply(Long ptNo,String cause){
        try{
            //修改住院病人信息
            ZyPatientBase zpb = new ZyPatientBase();
            zpb.setPtNo(ptNo);
            zpb.setPtIs(1L);
            pbm.updateById(zpb);//修改状态

            //修改申请出院信息
            QueryWrapper<ZyDischargeApply> qw = new QueryWrapper<>();
            qw.eq("pt_no",ptNo);
            qw.eq("dga_is",1);
            ZyDischargeApply zda = new ZyDischargeApply();
            zda.setDgaNoCause(cause);//取消原因
            zda.setDgaIs("3");
            dam.update(zda,qw);
            return true;
        }catch (Exception e){
            return false;
        }


    }
}
