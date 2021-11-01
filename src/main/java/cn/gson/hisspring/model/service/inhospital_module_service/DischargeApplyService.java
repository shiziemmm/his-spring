package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.BedMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DischargeApplyMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DischargeMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.pojos.ZyBed;
import cn.gson.hisspring.model.pojos.ZyDischarge;
import cn.gson.hisspring.model.pojos.ZyDischargeApply;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientCostVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 病人申请出院service
 */
@Service
@Transactional
public class DischargeApplyService {

    @Autowired
    DischargeApplyMapper dam;//出院申请mapper

    @Autowired
    DischargeMapper dm;//出院记录mapper

    @Autowired
    PatientBaseMapper pbm;//住院登记mapper

    @Autowired
    BedMapper bm;//病床mapper

    /**
     * 查询出所有已经出院的病人信息
     */
    public List<ZyDischarge> selectDischargeAll(SelectExecuteVo selectExecuteVo) {
        return dm.selectDischargeAll(selectExecuteVo);
    }


    /**
     * 添加病人申请
     */
    public String addDischargeApply(ZyDischargeApply zyDischarge) {
        String err = "";//错误提示
        zyDischarge.setDgaIs("1");

        //==========================判断医嘱是否全部执行完成


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
     * 根据住院号查询费用信息
     */
    public Double costDischargeAllByPtNo(Long ptNo, String text) {
        List<PatientCostVo> patientCostVos = dam.costDischargeAllByPtNo(ptNo, text);
        if (!patientCostVos.isEmpty()) {
            return patientCostVos.get(0).getPcdPrice();
        }
        return 0d;

    }

    /**
     * 查询已经申请的病人信息
     */
    public List<ZyDischargeApply> selectDischargeApplyAll(String search) {
        List<ZyDischargeApply> zyDischargeApplyList = dam.selectDischargeApplyAll(search);
        return zyDischargeApplyList;
    }


    /**
     * 取消申请出院
     *
     * @param ptNo
     * @param cause
     * @return
     */
    public boolean callPatientApply(Long ptNo, String cause) {
        try {
            //修改住院病人信息
            ZyPatientBase zpb = new ZyPatientBase();
            zpb.setPtNo(ptNo);
            zpb.setPtIs(1L);
            pbm.updateById(zpb);//修改状态

            //修改申请出院信息
            QueryWrapper<ZyDischargeApply> qw = new QueryWrapper<>();
            qw.eq("pt_no", ptNo);
            qw.eq("dga_is", 1);
            ZyDischargeApply zda = new ZyDischargeApply();
            zda.setDgaNoCause(cause);//取消原因
            zda.setDgaIs("3");
            dam.update(zda, qw);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 根据住院号出院
     */
    public boolean addDischargeByPtNo(ZyDischarge zyDischarge) {
        //根据住院号修改出院状态
        ZyPatientBase zyPatientBase = new ZyPatientBase();
        zyPatientBase.setPtIs(2L);
        zyPatientBase.setPtNo(zyDischarge.getPtNo());
        zyPatientBase.setPtOutDate(new Timestamp(new Date().getTime()));
        pbm.updateById(zyPatientBase);//修改

        //根据住院号清空病人病床
        QueryWrapper<ZyBed> qw = new QueryWrapper<ZyBed>().eq("pt_no", zyDischarge.getPtNo());
        List<ZyBed> BedList = bm.selectList(qw);
        if (!BedList.isEmpty()) {
            ZyBed zyBed = new ZyBed();
            zyBed.setPtNo(zyDischarge.getPtNo());
            zyBed.setBdIs(1L);
            bm.updateById(zyBed);//修改
        }

        //修改出院申请状态
        ZyDischargeApply zyDischargeApply = new ZyDischargeApply();
        zyDischargeApply.setDgaId(zyDischarge.getDgaId());
        zyDischargeApply.setDgaIs("2");
        dam.updateById(zyDischargeApply);//修改

        //新增出院记录
        int i = dm.insert(zyDischarge);
        if (i > 0)
            return true;
        return false;
    }
}
