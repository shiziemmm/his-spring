package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.InHospitalApplyMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalCardMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzSickMapper;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.MzSick;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.ZyInhospitalApply;
import cn.gson.hisspring.model.pojos.pojos_vo.InHospitalMzVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 */
@Service
@Transactional
public class InHospitalApplyService {

    @Autowired
    InHospitalApplyMapper ham;

    @Autowired
    MzSickMapper mzSickMapper;//病人信息

    @Autowired
    MzMedicalCardMapper mzMedicalCardMapper;//诊疗卡

    /**
     * 新增住院申请
     */
    public boolean addHospital(InHospitalMzVo inHospitalMzVo){
        //=======================新增患者信息
        MzSick mzSick = new MzSick();
        mzSick.setMcNumberCard(inHospitalMzVo.getMcNumberCard());
        mzSick.setSickAge(inHospitalMzVo.getSickAge());
        mzSick.setSickIdCard(inHospitalMzVo.getSickIdCard());
        mzSick.setSickName(inHospitalMzVo.getSickName());
        mzSick.setSickSex(inHospitalMzVo.getSickSex());
        mzSick.setSickSite(inHospitalMzVo.getSickSite());
        mzSick.setSickPhone(inHospitalMzVo.getSickPhone());
        mzSickMapper.insert(mzSick);//新增


        //====================新增诊疗卡信息
        MzMedicalCard card = new MzMedicalCard();
        card.setMcCard(mzSick.getMcNumberCard());
        System.out.println("卡号"+mzSick.getMcNumberCard());
        card.setMcIdCard(mzSick.getSickIdCard());
        card.setMcPawd(getIdCard(mzSick.getSickIdCard()));
        card.setMcBalance(0);
        card.setSickNumber(mzSick.getSickNumber());
        card.setMcSate(0);
        mzMedicalCardMapper.insert(card);

        //========================新增住院申请
        ZyInhospitalApply zyInhospitalApply = new ZyInhospitalApply();
        zyInhospitalApply.setsId(inHospitalMzVo.getOperatorId());//操作员
        zyInhospitalApply.setInIs(1L);//申请状态
        zyInhospitalApply.setKsId(inHospitalMzVo.getKsId());//住院科室
        zyInhospitalApply.setInApplyDate(new Date());
        zyInhospitalApply.setSickNumber(mzSick.getSickNumber());
        int is = ham.insert(zyInhospitalApply);//新增

        if(is > 0)
            return true;
        return false;
    }

    /**
     * 查询所有未审核的住院申请
     * @return
     */
    public List<ZyInhospitalApply> selectHspApplyByInIs(SelectExecuteVo selectExecuteVo){
        List<ZyInhospitalApply> list = ham.selectHspApplyByInIs("1",selectExecuteVo.getDoctorType(),selectExecuteVo.getSearchLike(),selectExecuteVo.getStartDate(),selectExecuteVo.getEndDate());//查询未审核的住院申请信息
        return list.isEmpty() ? null : list;
    }

    /**
     * 查询出所有主治医生
     */
    public List<Staff> selectPatientStaffAll(){
       return ham.selectPatientStaffAll();
    }

    /**
     * 根据住院申请编号修改住院申请状态为取消状态
     * @return
     */
    public boolean HspApplyByInIdUpdateInIs(Long inId){
        ZyInhospitalApply hos = new ZyInhospitalApply(inId,3L);
        int is = ham.updateById(hos);//修改
        return is > 0;
    }

    //截取身份证后六位有X就跳过
    public String getIdCard(String id){
        Pattern p = Pattern.compile("[0-9]+[X|x]{1}");
        Matcher m = p.matcher(id);
        boolean b = m.matches();
        if(b){
            id = id.substring(id.length()-7,id.length()-1);
        }else{
            id = id.substring(id.length()-6);
        }
        return id;
    }
}
