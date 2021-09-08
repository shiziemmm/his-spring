package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.config.MyUtilCardConfig;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.*;
import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 就诊记录表 service
 */

@Service
@Transactional
public class MzMedicalRecordService {
    @Autowired
    MzMedicalRecordMapper medicalRecordMapper; //就诊记录mapper
    @Autowired
    MzRecipeMapper recipeMapper;//处方表
    @Autowired
    MzXprescriptionMapper xpMapper;//西药
    @Autowired
    MzZprescriptionMapper zpMapper;//中药
    @Autowired
    MzOpcNumberMapper opcNumberMapper;//排号
    @Autowired
    MzCaseHistoryMapper historyMapper;//病历表

//    @Autowired
//    MzRegistrationMapper registrationMapper;//门诊挂号表

    @Autowired
    MzPaymentMapper paymentMapper;

    /**
     添加处方表--只做处方 和就诊记录的添加
     */
    public void addRecipe(RecordVo recordVo ){
        MzMedicalRecord medicalRecordObject = recordVo.getMedicalRecordObject();

        MzRecipe recipeObject = recordVo.getRecipeObject();



        //新增就诊记录表 和修改排号表状态
        if(recordVo.getMedicalRecordObject() !=null){
            //修改排号表状态
            long bnNumber = medicalRecordObject.getBnNumber();
            QueryWrapper qw = new QueryWrapper();
            qw.eq("bn_number",bnNumber);
            MzOpcNumber opcNumber = opcNumberMapper.selectOne(qw);
            opcNumber.setBnState(1);
            opcNumberMapper.updateById(opcNumber);
            medicalRecordObject.setMrOverTime(new Timestamp(System.currentTimeMillis()));//这个是修改时间，就是结束就诊时间对应时间，
            medicalRecordMapper.insert(medicalRecordObject);
        }
        //新增病历表
        MzCaseHistory historyObject = recordVo.getHistoryObject();
        if(historyObject!=null){
            historyObject.setSickNumber(recipeObject.getSickNumber());//新增病人外键
            historyObject.setMrNumber(medicalRecordObject.getMrNumber());//新增就诊记录表
            historyMapper.insert(historyObject);
        }
        //新增处方
        if(recordVo.getRecipeObject() !=null){
            recipeObject.setMrNumber(medicalRecordObject.getMrNumber());
            recipeMapper.insert(recipeObject);
        }
        //新增西药
        if(!recordVo.getRecipeObject().getXpList().isEmpty()){
            List<MzXprescription> xpLists = recordVo.getRecipeObject().getXpList();
            for (MzXprescription xpList : xpLists) {
                xpList.setRecipeNumber(recipeObject.getRecipeNumber());//外键-新增处方单号
                System.err.println("xp="+xpList);
                xpList.setRdStatePrice(0);
            }
           xpMapper.addListXp(xpLists);
        }
        //新增中药
        if(!recordVo.getRecipeObject().getZpList().isEmpty()){
            List<MzZprescription> zpList = recordVo.getRecipeObject().getZpList();
            for (MzZprescription mzZprescription : zpList) {
                mzZprescription.setRecipeNumber(recipeObject.getRecipeNumber());//外键-新增处方单号
                mzZprescription.setZpStatePrice(0);
                System.err.println("zp="+mzZprescription);
            }
            zpMapper.addListZp(zpList);
            for (MzZprescription mzZprescription : zpList) {
                System.err.println(mzZprescription);
            }
        }

    }
    /**
     *  查询就诊记录表
     */
    public List<MzMedicalRecord> selectMedicalRecord(String index,String texts){
       return medicalRecordMapper.selectMzMedicalRecord(index, texts);
    }
    /**
     *  查询就诊记录表--缴费记录查询
     */
    public MzMedicalRecord selectMedicalRecord(String texts){
        return medicalRecordMapper.selectMzMedicalRecords( texts);
    }



    /**
     * 修改处方表的缴费状态
     */
    public void updateStateRecipe(String index,String xmName,MzPayment payment){
        //条件构造寻找对应的id
        QueryWrapper qw = new QueryWrapper();
        qw.eq("recipe_Number",index);

        if(xmName.equals("西药处方")){
            List<MzXprescription> xp = xpMapper.selectList(qw);
            for (MzXprescription mzXprescription : xp) {
                mzXprescription.setRdStatePrice(1);
                xpMapper.updateById(mzXprescription);
            }
        }
        if(xmName.equals("中药处方")){
            List<MzZprescription> zp =  zpMapper.selectList(qw);
            for (MzZprescription mzZprescription : zp) {
                mzZprescription.setZpStatePrice(1);
                zpMapper.updateById(mzZprescription);
            }
        }
        // 查询一遍处方表
        MzRecipe mzRecipe = recipeMapper.selectOne(qw);
        // 修改状态后存入缴费记录表中
        MzPayment mzPayment = new MzPayment();
        //自动生成缴费单号
        MyUtilCardConfig myUtilCardConfig = new MyUtilCardConfig();
        mzPayment.setPmNumberCount("MZJF"+myUtilCardConfig.numberNot(6));
        //对传过来的对象进行挨个赋值
        mzPayment.setPmCard(payment.getPmCard());
        mzPayment.setPmSum(payment.getPmSum());
        mzPayment.setPmType(payment.getPmType());
        mzPayment.setPmTypeId(payment.getPmTypeId());
        mzPayment.setSId(payment.getSId());
        mzPayment.setSickNumber(payment.getSickNumber());

        paymentMapper.insert(mzPayment);


    }


    /**
     * 查询所有的缴费完成记录
     * @return
     */
    public List<MzMedicalRecord> selectRecordsAll(String text){
        List<MzMedicalRecord> mzMedicalRecords = medicalRecordMapper.selectRecordsAll(text);
        return mzMedicalRecords;
    }


    /**
     * 病人信息查询 已经就诊完成了的人
     * @return
     */
    public List<MzMedicalRecord> allRecordSick(String text){
        List<MzMedicalRecord> mzMedicalRecords = medicalRecordMapper.allRecordSick(text);
        return mzMedicalRecords;
    }

}
