package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.config.MyUtilCardConfig;
import cn.gson.hisspring.model.mapper.checkout_module_mapper.TjManMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.*;
import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.ReCordAllVO;
import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
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
    MzPaymentMapper paymentMapper;  // 缴费记录表
    @Autowired
    TjManMapper tjManMapper;//体检人员mapper
    @Autowired
    MzTjManResultMapper tjManResultMapper; // 循环添加检验项目集合
    @Autowired
    MzCenterSurgeryMapper centerSurgeryMapper;// 手术集合详表mapper
    @Autowired
    MzSurgeryStampMapper surgeryStampMapper;//手术单表mapper

    @Autowired
    ReCordAllVOMapper reCordAllVOMapper;

    /**
     * 查询所有的Vo对象组合类
     * @param index
     * @param texts
     * @return
     */
    public List<ReCordAllVO> selectAllRecord(String index,String texts){
      return reCordAllVOMapper.selectAllReCordObject(index,texts);
    };

    /**
     添加处方表--只做处方 和就诊记录的添加
     */
    public void addRecipe(RecordVo recordVo ){
//        就诊记录
        MzMedicalRecord medicalRecordObject = getMzMedicalRecord(recordVo);
//        处方
        MzRecipe recipeObject = getMzRecipe(recordVo, medicalRecordObject);
//        检验
        getTjCodeResult(recordVo, medicalRecordObject);
//        手术
        getSurgeryStamp(recordVo, medicalRecordObject);
        //新增病历表
        MzCaseHistory historyObject = recordVo.getHistoryObject();
        if(historyObject.getChComplaint() !=null && historyObject.getChComplaint() !=""){
            historyObject.setChDoctor(medicalRecordObject.getMrDoctorName());//新增主治医生
            historyObject.setSickNumber(recipeObject.getSickNumber());//新增病人外键
            historyObject.setMrNumber(medicalRecordObject.getMrNumber());//新增就诊记录表
            historyMapper.insert(historyObject);
        }
    }
    /**
     * 新增就诊记录表-----------这里的修改排号状态要做判断
     * @param recordVo
     * @return
     */
    private MzMedicalRecord getMzMedicalRecord(RecordVo recordVo) {
        MzMedicalRecord medicalRecordObject = recordVo.getMedicalRecordObject();
        //新增就诊记录表 和修改排号表状态
        if(recordVo.getMedicalRecordObject().getMrCount()!= "" && recordVo.getMedicalRecordObject().getMrCount()!= null){
            //修改排号表状态
            long bnNumber = medicalRecordObject.getBnNumber();
            QueryWrapper qw = new QueryWrapper();
            qw.eq("bn_number",bnNumber);
            MzOpcNumber opcNumber = opcNumberMapper.selectOne(qw);
            opcNumber.setBnState(1);
            opcNumberMapper.updateById(opcNumber);
//            一个时间用于接诊保存时间 ，一个时间用于结束就诊时间
            medicalRecordMapper.insert(medicalRecordObject);
        }
        return medicalRecordObject;
    }

    /**
     * 添加手术
     * @param recordVo
     * @param medicalRecordObject
     */
    private void getSurgeryStamp(RecordVo recordVo, MzMedicalRecord medicalRecordObject) {
        if(!recordVo.getCenterSurgeryList().isEmpty()){
            MzSurgeryStamp surgeryStampObject = recordVo.getSurgeryStampObject();
            // 添加手术单表
            surgeryStampObject.setsId(medicalRecordObject.getsId());
            surgeryStampObject.setMrNumber(medicalRecordObject.getMrNumber());
            surgeryStampObject.setSickNumber(medicalRecordObject.getSickNumber());
            surgeryStampObject.setSusState(0);
            surgeryStampMapper.insert(surgeryStampObject);
            //添加中间表
            List<MzCenterSurgery> centerSurgeryList = recordVo.getCenterSurgeryList();
            for (MzCenterSurgery mzCenterSurgery : centerSurgeryList) {
                mzCenterSurgery.setSusNumber(surgeryStampObject.getSusNumber());
                mzCenterSurgery.setSusPayState(0L);
            }
            centerSurgeryMapper.addCenterSurgery(centerSurgeryList);
        }
    }

    /**
     * 添加体检记录表
     * @param recordVo
     * @param medicalRecordObject
     */
    private void getTjCodeResult(RecordVo recordVo, MzMedicalRecord medicalRecordObject) {
        if(!recordVo.getTjManResultList().isEmpty()) {//如果没有值说明为空
            TjCodeMan tjCodeManObject =  recordVo.getTjCodeManObject();
            //体检申请单表对象
            tjCodeManObject.setManState(0L);
            tjCodeManObject.setManMzZyIs(1);//判断是门诊状态
            tjCodeManObject.setManMzZyId(medicalRecordObject.getMrCount());//添加问诊号
            System.err.println("生日"+ recordVo.getTjCodeManObject().getManBirthtime());
            tjCodeManObject.setManTime(new Timestamp(System.currentTimeMillis()));
            tjManMapper.insert(tjCodeManObject);
//            如果不等于空集合
            List<TjManResult> tjManResult = recordVo.getTjManResultList();
            for (TjManResult manResult : tjManResult) {
                //循环赋值id
                manResult.setsId(medicalRecordObject.getsId());
                manResult.setManId(tjCodeManObject.getManId());
            }
            tjManResultMapper.addTjManResultArr(tjManResult);

        }
    }

    /**
     * 新增处方表
     * @param recordVo
     * @param medicalRecordObject
     * @return
     */
    private MzRecipe getMzRecipe(RecordVo recordVo, MzMedicalRecord medicalRecordObject) {
        MzRecipe recipeObject = recordVo.getRecipeObject();
        //新增处方
        if(recordVo.getRecipeObject().getRecipeSickName() != null && recordVo.getRecipeObject().getRecipeSickName() != ""){
            recipeObject.setMrNumber(medicalRecordObject.getMrNumber());
            recipeMapper.insert(recipeObject);
            //新增西药
            if(!recordVo.getRecipeObject().getXpList().isEmpty() && recordVo.getRecipeObject().getXpList() !=null ){
                List<MzXprescription> xpLists = recordVo.getRecipeObject().getXpList();
                for (MzXprescription xpList : xpLists) {
                    xpList.setRecipeNumber(recipeObject.getRecipeNumber());//外键-新增处方单号
                    xpList.setRdStatePrice(0);
                }
                xpMapper.addListXp(xpLists);
            }
            //新增中药
            if(!recordVo.getRecipeObject().getZpList().isEmpty() && recordVo.getRecipeObject().getZpList() !=null){
                List<MzZprescription> zpList = recordVo.getRecipeObject().getZpList();
                for (MzZprescription mzZprescription : zpList) {
                    mzZprescription.setRecipeNumber(recipeObject.getRecipeNumber());//外键-新增处方单号
                    mzZprescription.setZpStatePrice(0);
                }
                zpMapper.addListZp(zpList);
            }
        }
        return recipeObject;
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
        return medicalRecordMapper.selectMzMedicalRecords(texts);
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
            //添加到缴费记录表中
            extracted(payment, qw);
        }
        if(xmName.equals("中药处方")){
            List<MzZprescription> zp =  zpMapper.selectList(qw);
            for (MzZprescription mzZprescription : zp) {
                mzZprescription.setZpStatePrice(1);
                zpMapper.updateById(mzZprescription);
            }
            //添加到缴费记录表中
            extracted(payment, qw);
        }
    }

    /**
     * 添加到缴费记录表中
     */
    private void extracted(MzPayment payment, QueryWrapper qw) {
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

    /**
     * 门诊查询手术等级
     * @return
     */
    public  List<Object> selectAllSsObjectType(){
        return medicalRecordMapper.selectAllSsObjectType();
    }

    /**
     * 模糊查询手术项目
     * @return
     */
    public List<SsOperationProject> mzSelectAllSsObject(String projectName,String projectType){
        List<SsOperationProject> listap = medicalRecordMapper.mzSelectAllSsObject(projectName,projectType);
        return  listap;
    }

}
