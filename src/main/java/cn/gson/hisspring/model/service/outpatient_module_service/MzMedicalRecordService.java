package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.config.MyUtilCardConfig;
import cn.gson.hisspring.model.mapper.checkout_module_mapper.TjManMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.*;
import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.ReCordAllVO;
import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
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
        List<ReCordAllVO> reCordAllVOS = reCordAllVOMapper.selectAllReCordObject(index, texts);
        for (ReCordAllVO reCordAllVO : reCordAllVOS) {
            //处方值不为null ，回流添加改换集合
            if(reCordAllVO.getRecipeObject() !=null){
                if(reCordAllVO.getRecipeObject().getRecipeNumber() != 0){
                    List<MzRecipe> mzRecipes = reCordAllVOMapper.selectAllReCordOrDrug(reCordAllVO.getRecipeObject().getRecipeNumber());
                    for (MzRecipe mzRecipe : mzRecipes) {
                        if(!mzRecipe.getXpList().isEmpty()){
                            reCordAllVO.getRecipeObject().setXpList(mzRecipe.getXpList());
                        }
                        if(!mzRecipe.getZpList().isEmpty()){
                            reCordAllVO.getRecipeObject().setZpList(mzRecipe.getZpList());
                        }
                    }
                }
            }
            //体检值不为null ，回流添加改换集合
            if(reCordAllVO.getTjCodeManObject() != null){
                if(reCordAllVO.getTjCodeManObject().getManId()!=0){
                    List<TjCodeMan> reCordAllVOTjs = reCordAllVOMapper.selectAllReCordOrTj(reCordAllVO.getTjCodeManObject().getManId());
                    for (TjCodeMan reCordAllVOTj : reCordAllVOTjs) {
                        if(!reCordAllVOTj.getTjManResultList().isEmpty()){
                            reCordAllVO.setTjManResultList(reCordAllVOTj.getTjManResultList());
                        }
                    }
                }
            }
            //手术值不为null ，回流添加改换集合
            if(reCordAllVO.getSurgeryStampObject() != null){
                if(reCordAllVO.getSurgeryStampObject().getSusNumber() != 0){
                    List<MzSurgeryStamp> reCordAllVOSses = reCordAllVOMapper.selectAllReCordOrSs(reCordAllVO.getSurgeryStampObject().getSusNumber());
                    for (MzSurgeryStamp reCordAllVOSs : reCordAllVOSses) {
                        if(!reCordAllVOSs.getCenterSurgeryList().isEmpty()){
                            reCordAllVO.setCenterSurgeryList(reCordAllVOSs.getCenterSurgeryList());
                        }
                    }
                }
            }
        }

        return reCordAllVOS;
    };
    /**
     * 删除对应的中间表
     * @param index
     * @param i
     */
    public void delectRecord(Long index,Long i){
        QueryWrapper qw = new QueryWrapper();
        if(index==1){
            qw.eq("rd_number",i);
                xpMapper.delete(qw);
        }else if(index==2){
            qw.eq("zp_Number",i);
                zpMapper.delete(qw);
        }else if(index==3){
            qw.eq("man_result_id",i);
                tjManResultMapper.delete(qw);
        }else if(index==4){
            qw.eq("sus_Id",i);
                centerSurgeryMapper.delete(qw);
        }
    }


    /**
     * 依此类推来判断是进：保存，还是结束就诊，还是二次保存
     */
    public void addRecipes(RecordVo recordVo){
        if(recordVo.getMedicalRecordObject().getMrNumber() == 0){
            addRecipe(recordVo);
        }else{
            addRecipeServe(recordVo);
        }
    }

    /**
     * 二次保存或者结束就诊
     * @param recordVo
     */
    private void addRecipeServe(RecordVo recordVo) {
        //        如果有就诊记录就修改了它 先查询一遍在修改
        UpdateWrapper uw = new UpdateWrapper();
        uw.eq("mr_Number", recordVo.getMedicalRecordObject().getMrNumber());
        MzMedicalRecord medicalRecordObject = medicalRecordMapper.selectOne(uw);
        medicalRecordMapper.update(recordVo.getMedicalRecordObject(),uw);
        System.err.println("这里是走回传二次保存");
        //如果“处方”的id有值，说明是双击回传过来的就诊列表的人
        if(recordVo.getRecipeObject().getRecipeNumber() !=0 ){
            UpdateWrapper qwRe = new UpdateWrapper();
            qwRe.eq("mz_recipe.recipe_Number", recordVo.getRecipeObject().getRecipeNumber());
            MzRecipe mzRecipe = recipeMapper.selectOne(qwRe);
            recipeMapper.update(recordVo.getRecipeObject(),qwRe);//查询一遍而后修改
            if(mzRecipe!=null){//非空判断
                //对西药处方做判断二次保存
                if(!recordVo.getRecipeObject().getXpList().isEmpty() && recordVo.getRecipeObject().getXpList() !=null ){
                    List<MzXprescription> xpLists = recordVo.getRecipeObject().getXpList();
                    List<MzXprescription> xpLists1 = new ArrayList<>();
                    // 根据id遍历查询有就作修改，没就新增到另一个集合中作为新增
                    for (MzXprescription xpList : xpLists) {
                        if(xpList.getRdNumber()!=0){
                            UpdateWrapper qws =new UpdateWrapper();
                            qws.eq("mz_xprescription.rd_number",xpList.getRdNumber());
                            MzXprescription mzXprescription = xpMapper.selectOne(qws);
                            if(mzXprescription!=null){
                                xpMapper.update(xpList,qws);
                            }
                        }else if(xpList.getRdNumber()==0 && xpList.getRdName() !=null){
                            xpList.setRecipeNumber(mzRecipe.getRecipeNumber());//外键-新增处方单号
                            xpList.setRdStatePrice(0);
                            xpLists1.add(xpList);
                        }
                    }
                    //如果不是一个空集合就说明上面存进去了值，就可以新增
                    if(!xpLists1.isEmpty()){
                        xpMapper.addListXp(xpLists1);
                    }
                }
                //对中药处方做判断二次保存
                if(!recordVo.getRecipeObject().getZpList().isEmpty() && recordVo.getRecipeObject().getZpList()!=null){
                    List<MzZprescription> zpList = recordVo.getRecipeObject().getZpList();
                    List<MzZprescription> zpLists2 = new ArrayList<>();
                    // 根据id遍历查询有就作修改，没就新增到另一个集合中作为新增
                    for (MzZprescription mzZprescription : zpList) {
                        if(mzZprescription.getZpNumber() !=0){
                            UpdateWrapper uwZp = new UpdateWrapper();
                            uwZp.eq("mz_zprescription.zp_number",mzZprescription.getZpNumber());
                            MzZprescription mzZprescription1 = zpMapper.selectOne(uwZp);
                            if(mzZprescription!=null){
                                zpMapper.update(mzZprescription,uwZp);
                            }
                        }else if(mzZprescription.getZpNumber() == 0 && mzZprescription.getZpName()!=null){
                            mzZprescription.setRecipeNumber(mzRecipe.getRecipeNumber());//外键-新增处方单号
                            mzZprescription.setZpStatePrice(0);
                            zpLists2.add(mzZprescription);
                        }
                    }
                    //如果不是一个空集合就说明上面存进去了值，就可以新增
                    if(!zpLists2.isEmpty()){
                        zpMapper.addListZp(zpLists2);
                    }
                }

            }
        }
        //如果“体检”的id有值，说明是双击回传过来的就诊列表的人
        if(recordVo.getTjCodeManObject() != null){
            if(recordVo.getTjCodeManObject().getManId()!=null){
                //有就做修改
                UpdateWrapper qwTj = new UpdateWrapper();
                qwTj.eq("tj_code_man.man_id", recordVo.tjCodeManObject.getManId());
                TjCodeMan tjCodeMan = tjManMapper.selectOne(qwTj);
                tjManMapper.update(recordVo.getTjCodeManObject(),qwTj);//查询一遍而后修改
                if(!recordVo.getTjManResultList().isEmpty()  && recordVo.getTjManResultList()!=null){
                    List<TjManResult> tjManResult = recordVo.getTjManResultList();
                    List<TjManResult> listResult = new ArrayList<>();
                    // 根据id遍历查询有就作修改，没就新增到另一个集合中作为新增
                    for (TjManResult manResult : tjManResult) {
                        if(manResult.getManResultId() !=0){
                            UpdateWrapper qwResult = new UpdateWrapper();
                            qwResult.eq("tj_man_result.man_result_id",manResult.getManResultId());
                            TjManResult tjManResult1 = tjManResultMapper.selectOne(qwResult);
                            if(tjManResult1!=null){
                                tjManResultMapper.update(manResult,qwResult);
                            }
                        }else if(manResult.getManResultId() == 0 && manResult.getCheckId()!=0){
                            manResult.setsId(medicalRecordObject.getsId());
                            manResult.setManId(tjCodeMan.getManId());
                            manResult.setManPayState(0L);
                            listResult.add(manResult);
                        }
                    }
                    //如果不是一个空集合就说明上面存进去了值，就可以新增
                    if(!listResult.isEmpty()){
                        tjManResultMapper.addTjManResultArr(listResult);
                    }
                }
            }
        }

        //如果“手术”的id有值，说明是双击回传过来的就诊列表的人
        if(recordVo.getSurgeryStampObject().getSusNumber() !=0){
            UpdateWrapper qwSs = new UpdateWrapper();
            qwSs.eq("mz_surgery_stamp.sus_Number", recordVo.getSurgeryStampObject().getSusNumber());
            MzSurgeryStamp mzSurgeryStamp = surgeryStampMapper.selectOne(qwSs);
            surgeryStampMapper.update(recordVo.getSurgeryStampObject(),qwSs);//查询一遍而后修改
            if(!recordVo.getCenterSurgeryList().isEmpty() && recordVo.getCenterSurgeryList() !=null){
                List<MzCenterSurgery> centerSurgeryList = recordVo.getCenterSurgeryList();
                List<MzCenterSurgery> centerSurgeryList2 = new ArrayList<>();
                for (MzCenterSurgery mzCenterSurgery : centerSurgeryList) {
                    if(mzCenterSurgery.getSusId()!=0){
                        UpdateWrapper uwCen = new UpdateWrapper();
                        uwCen.eq("mz_center_surgery.sus_id",mzCenterSurgery.getSusId());
                        MzCenterSurgery mzCenterSurgery1 = centerSurgeryMapper.selectOne(uwCen);
                        if(mzCenterSurgery1!=null){
                            centerSurgeryMapper.update(mzCenterSurgery,uwCen);
                        }
                    }else if(mzCenterSurgery.getSusId()==0 && mzCenterSurgery.getProjectId()!=0){
                        mzCenterSurgery.setSusNumber(mzSurgeryStamp.getSusNumber());
                        mzCenterSurgery.setSusPayState(0L);
                        centerSurgeryList2.add(mzCenterSurgery);
                    }
                }
                //如果不是一个空集合就说明上面存进去了值，就可以新增
                if(!centerSurgeryList2.isEmpty()){
                    centerSurgeryMapper.addCenterSurgery(centerSurgeryList2);
                }
            }
        }
        //如果“病例”的id有值，说明是双击回传过来的就诊列表的人
        if(recordVo.getHistoryObject().getChNumber() !=0){
            UpdateWrapper qwHis = new UpdateWrapper();
            qwHis.eq("ch_Number", recordVo.getHistoryObject().getChNumber());
            MzCaseHistory mzCaseHistory = historyMapper.selectOne(qwHis);
            historyMapper.update(recordVo.getHistoryObject(),qwHis);//查询一遍而后修改
        }
    }

    /**
      保存添加，结束也得添加
     */
    public void addRecipe(RecordVo recordVo){
//        就诊记录
        MzMedicalRecord medicalRecordObject = getMzMedicalRecord(recordVo);
//        处方
        MzRecipe recipeObject = getMzRecipe(recordVo, medicalRecordObject);
//        检验
        getTjCodeResult(recordVo, medicalRecordObject);
//        手术
        getSurgeryStamp(recordVo, medicalRecordObject);
//      新增病历表
        getHistoryObject(recordVo, medicalRecordObject);
    }

    /**
     * 病历表
     * @param recordVo
     * @param medicalRecordObject
     */
    private void getHistoryObject(RecordVo recordVo, MzMedicalRecord medicalRecordObject) {
        MzCaseHistory historyObject = recordVo.getHistoryObject();
        historyObject.setChDoctor(medicalRecordObject.getMrDoctorName());//新增主治医生
        historyObject.setSickNumber(medicalRecordObject.getSickNumber());//新增病人外键
        historyObject.setChIs(1L);//一就是门诊
        historyObject.setChZyMzId(medicalRecordObject.getMrNumber());//新增就诊记录表
        historyObject.setChSid(medicalRecordObject.getsId());
        historyMapper.insert(historyObject);
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
        MzSurgeryStamp surgeryStampObject = recordVo.getSurgeryStampObject();
        // 添加手术单表
        surgeryStampObject.setsId(medicalRecordObject.getsId());
        surgeryStampObject.setMrNumber(medicalRecordObject.getMrNumber());
        surgeryStampObject.setSickNumber(medicalRecordObject.getSickNumber());
        surgeryStampObject.setSusState(0);
        surgeryStampMapper.insert(surgeryStampObject);
        if(!recordVo.getCenterSurgeryList().isEmpty()){
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
        TjCodeMan tjCodeManObject =  recordVo.getTjCodeManObject();
        //体检申请单表对象
        tjCodeManObject.setManState(0L);
        tjCodeManObject.setManMzZyIs(1);//判断是门诊状态
        tjCodeManObject.setManMzZyId(medicalRecordObject.getMrCount());//添加问诊号
        tjCodeManObject.setManTime(new Timestamp(System.currentTimeMillis()));
        tjManMapper.insert(tjCodeManObject);
        if(!recordVo.getTjManResultList().isEmpty()) {//如果没有值说明为空
//            如果不等于空集合
            List<TjManResult> tjManResult = recordVo.getTjManResultList();
            for (TjManResult manResult : tjManResult) {
                //循环赋值id
                manResult.setsId(medicalRecordObject.getsId());
                manResult.setManId(tjCodeManObject.getManId());
                manResult.setManPayState(0L);
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
        recipeObject.setMrNumber(medicalRecordObject.getMrNumber());
        recipeMapper.insert(recipeObject);
        //新增处方
        if(recordVo.getRecipeObject().getRecipeSickName() != null && recordVo.getRecipeObject().getRecipeSickName() != ""){
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
     *  查询就诊记录表--未缴费，开始输入号码缴费
     * @return
     */
    public ReCordAllVO selectMedicalRecord(String texts){
        ReCordAllVO reCordAllVO1 = medicalRecordMapper.selectAllReCordObject2(texts);
        if( reCordAllVO1 !=null){
            //对处方的回流改集合
            if(reCordAllVO1.getRecipeObject().getRecipeNumber() != 0 ){
                List<MzRecipe> mzRecipes = reCordAllVOMapper.selectAllReCordOrDrug2(reCordAllVO1.getRecipeObject().getRecipeNumber(),0l);
                for (MzRecipe mzRecipe : mzRecipes) {
                    if(!mzRecipe.getXpList().isEmpty()){
                        reCordAllVO1.getRecipeObject().setXpList(mzRecipe.getXpList());
                    }
                    if(!mzRecipe.getZpList().isEmpty()){
                        reCordAllVO1.getRecipeObject().setZpList(mzRecipe.getZpList());
                    }
                }
            }
        //手术值不为null ，回流添加改换集合
            if(reCordAllVO1.getSurgeryStampObject() != null){
                if(reCordAllVO1.getSurgeryStampObject().getSusNumber() != 0){
                    List<MzSurgeryStamp> reCordAllVOSses = reCordAllVOMapper.selectAllReCordOrSs2(reCordAllVO1.getSurgeryStampObject().getSusNumber(),0L);
                    for (MzSurgeryStamp reCordAllVOSs : reCordAllVOSses) {
                        if(!reCordAllVOSs.getCenterSurgeryList().isEmpty()){
                            reCordAllVO1.setCenterSurgeryList(reCordAllVOSs.getCenterSurgeryList());
                        }
                    }
                }
            }
        }
        return reCordAllVO1;
    }

    /**
     * 查询所有的缴费完成记录--已经缴费，开始查询打印
     * @return
     */
    public List<ReCordAllVO> selectRecordsAll(String texts){
        List<ReCordAllVO> mzMedicalRecords = medicalRecordMapper.selectAllReCordObject3(texts);;
        for (ReCordAllVO mzMedicalRecord : mzMedicalRecords) {
            if( mzMedicalRecord !=null){
                //对处方的回流改集合
                if(mzMedicalRecord.getRecipeObject() !=null && mzMedicalRecord.getRecipeObject().getRecipeNumber() != 0){
                    List<MzRecipe> mzRecipes = reCordAllVOMapper.selectAllReCordOrDrug2(mzMedicalRecord.getRecipeObject().getRecipeNumber(),1l);
                    for (MzRecipe mzRecipe : mzRecipes) {
                        if(!mzRecipe.getXpList().isEmpty()){
                            mzMedicalRecord.getRecipeObject().setXpList(mzRecipe.getXpList());
                        }
                        if(!mzRecipe.getZpList().isEmpty()){
                            mzMedicalRecord.getRecipeObject().setZpList(mzRecipe.getZpList());
                        }
                    }
                }
                //手术值不为null ，回流添加改换集合
                if(mzMedicalRecord.getSurgeryStampObject() != null && mzMedicalRecord.getSurgeryStampObject().getSusNumber() != 0){
                    List<MzSurgeryStamp> reCordAllVOSses = reCordAllVOMapper.selectAllReCordOrSs2(mzMedicalRecord.getSurgeryStampObject().getSusNumber(),1L);
                    for (MzSurgeryStamp reCordAllVOSs : reCordAllVOSses) {
                        if(!reCordAllVOSs.getCenterSurgeryList().isEmpty()){
                            mzMedicalRecord.setCenterSurgeryList(reCordAllVOSs.getCenterSurgeryList());
                        }
                    }
                }
            }
        }
        return mzMedicalRecords;
    }
    /**
     * 修改处方表的缴费状态
     */
    public void updateStateRecipe(RecordVo recordVo){
        //条件构造寻找对应的id
        //根据处方修改药品
        if(recordVo.getRecipeObject() != null && recordVo.getRecipeObject().getRecipeNumber() !=0){
            /*先修改处方状态*/
            QueryWrapper qw1 = new QueryWrapper();
            qw1.eq("recipe_Number",recordVo.getRecipeObject().getRecipeNumber());
            MzRecipe mzRecipe = recipeMapper.selectOne(qw1);
            mzRecipe.setRecipeDrugState(1);
            recipeMapper.updateById(mzRecipe);
            /*西药药品修改*/
            if(!recordVo.getRecipeObject().getXpList().isEmpty() ){
                List<MzXprescription> xp = recordVo.getRecipeObject().getXpList();
                for (MzXprescription mzXprescription : xp) {
                    QueryWrapper qwXp = new QueryWrapper();
                    qwXp.eq("rd_number",mzXprescription.getRdNumber());
                    MzXprescription mzXprescription1 = xpMapper.selectOne(qwXp);
                    if(mzXprescription1!=null){
                        mzXprescription1.setRdStatePrice(1L);
                        xpMapper.updateById(mzXprescription1);
                    }
                }
                //添加到缴费记录表中
//                extracted(payment, qw);
            }
            /*中药药品修改*/
            if(!recordVo.getRecipeObject().getZpList().isEmpty()){
                List<MzZprescription> zp =  recordVo.getRecipeObject().getZpList();
                for (MzZprescription mzZprescription : zp) {
                    QueryWrapper qwZp = new QueryWrapper();
                    qwZp.eq("zp_number",mzZprescription.getZpNumber());
                    MzZprescription mzZprescription1 = zpMapper.selectOne(qwZp);
                    if(mzZprescription1!=null){
                        mzZprescription1.setZpStatePrice(1L);
                        zpMapper.updateById(mzZprescription1);
                    }
                }
                //添加到缴费记录表中
            }
        }
//        根据手术修改药品
        if(recordVo.getSurgeryStampObject() !=null && recordVo.getSurgeryStampObject().getSusNumber() !=0){
            //先修改手术对象的缴费状态
            QueryWrapper qw1 = new QueryWrapper();
            qw1.eq("sus_number",recordVo.getSurgeryStampObject().getSusNumber());
            MzSurgeryStamp mzSurgeryStamp = surgeryStampMapper.selectOne(qw1);
            mzSurgeryStamp.setSusState(1);
            surgeryStampMapper.updateById(mzSurgeryStamp);
            if(!recordVo.getCenterSurgeryList().isEmpty()){
                List<MzCenterSurgery> centerSurgeryList = recordVo.getCenterSurgeryList();
                for (MzCenterSurgery mzCenterSurgery : centerSurgeryList) {
                    QueryWrapper qw2 = new QueryWrapper();
                    qw2.eq("sus_id",mzCenterSurgery.getSusId());
                    MzCenterSurgery mzCenterSurgery1 = centerSurgeryMapper.selectOne(qw2);
                    if(mzCenterSurgery1!=null){
                        mzCenterSurgery1.setSusPayState(1L);
                        centerSurgeryMapper.updateById(mzCenterSurgery1);
                    }
                }

            }
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
     * 病人信息查询 已经就诊完成了的人所有人的就诊记录表（当天看病人数统计表页面）
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
