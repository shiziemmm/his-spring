package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.*;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientUpdateBedVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.rmi.runtime.Log;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 住院登记service层
 */
@Service
@Transactional
public class PatientBaseService {

    @Autowired
    PatientBaseMapper pbm;//住院登记mapper

    @Autowired
    DepartmentKsMapper dkm;//科室mapper

    @Autowired
    BedUseRecordMapper burm;//病床使用记录mapper

    @Autowired
    BedChangeRecordMapper bdrm;//床位调换记录mapper

    @Autowired
    BedMapper bm;//病床mapper

    @Autowired
    InHospitalApplyMapper ham;//住院申请mapper

    @Autowired
    PayMapper pm;//缴费mapper

    @Autowired
    ContactsService cs;//病人关系mapper

    @Autowired
    ChangeDeptMapper cdm;//病人转科记录mapper


    /**
     * 根据条件查询病人集合
     * @param sId
     * @param ksId
     * @param text
     * @return
     */
    public List<ZyPatientBase> selectPatientBySId(Long sId,Long ksId,String text){
       return pbm.selectPatientBySId(sId,ksId,text);
    }


    /**
     * 根据病人编号进行转科
     */
    public boolean patientChangeDept(ZyChangeDeptRecord deptRecord){
        System.err.println("==========================================="+deptRecord.getBdId());
       try {
           //=======================新增转科记录
           cdm.insert(deptRecord);//新增

           //==============================根据病人病床为空以及修改管理护士
           ZyPatientBase pb = new ZyPatientBase(deptRecord.getPtNo(),0L,deptRecord.getDoctorId(),deptRecord.getCdrAfterKs());
           pbm.updateById(pb);//修改

           //===================================修改病床使用记录的结束时间
           if(deptRecord.getBdId() != 0 || !deptRecord.getBdId().equals("")){//判断是否入住病床
               ZyBedUseRecord bedUseRecord = selectBedUseRecord(deptRecord.getPtNo());//查询
               if(bedUseRecord != null){
                   ZyBedUseRecord zbr = new ZyBedUseRecord(bedUseRecord.getUrId(),new Timestamp(new Date().getTime()));
                   burm.updateById(zbr);//修改
               }

               //===========================================根据病床编号修改病床住院号为0
               ZyBed bed = new ZyBed(deptRecord.getBdId(),1L,0L);
               bm.updateById(bed);//修改
           }


           if(deptRecord.getCdrDoctorIs() == 1){//=============医嘱跟随
           }else{//============================医嘱不跟随
           }
           return true;

       }catch (Exception e){
            return false;
       }
    }


    /**
     * 根据病人住院号查询出该病人最后一条使用记录
     */
    public ZyBedUseRecord selectBedUseRecord(Long ptNo){
        //===================添加当前病床记录里面的结束时间
        QueryWrapper<ZyBedUseRecord> qwb = new QueryWrapper<>();//条件构造器
        qwb
                .eq("pt_no",ptNo)//根据住院号查询病床记录
                .orderBy(true,false,"ur_use_date");
        List<ZyBedUseRecord> list = burm.selectList(qwb);//查询

        if(list.isEmpty()){//如果没有病床使用记录就不继续走
            return null;
        }
        return list.get(0);//选中第一条数据
    }

    /**
     * 查询住院登记里面没有分配病床的信息或者是查询所有
     * @return
     */
    public List<ZyPatientBase> selectPatientNoBed(String is){//is 如果不是空就说明是要查询病床号为空的

//        QueryWrapper<ZyPatientBase> qw = new QueryWrapper<>();

//        if(is != ""){
//            qw
//                    .eq("bd_id",0)//查询病床编号为空的 0就是为空
//                    .isNull("pt_out_date")//查询出院日期为空的
//            ;
//        }


        List<ZyPatientBase> list = pbm.selectPatientNoBed(is);

//        if(list.isEmpty()){
//            return null;
//        }
//
//        for (ZyPatientBase pd : list) {
//            if(pd.getKsId() != null){
//                QueryWrapper<DepartmentKs> qwk = new QueryWrapper<>();
//                qwk.eq("ks_id",pd.getKsId());//根据科室编号查询
//                DepartmentKs dks = dkm.selectOne(qwk);
//                pd.setKsName(dks.getKsName());//将科室名称放入住院登记里面去
//            }
//        }
        return list.isEmpty() ? null : list;
    }


    /**
     * 根据住院号新增病床编号（ZyPatientBase）
     * 根据病床编号新增住院号（ZyBed）
     * 新增病床使用记录表数据（ZyBedUseRecord）
     * @return
     */
    public boolean PatientUpdateBdIdAndBedUpdateBdIsAndPtNo(Long bdId,Long ptNo,Double bdPrice){
        try {
            //根据住院号新增病床编号
            ZyPatientBase pd = new ZyPatientBase(ptNo,bdId);//根据住院号修改病床编号
            pbm.updateById(pd);

            //根据病床编号新增住院号
            ZyBed bed = new ZyBed(bdId,3L,ptNo);
            bm.updateById(bed);

            //新增病床使用记录表
            ZyBedUseRecord zbur = new ZyBedUseRecord(bdId,ptNo,new Timestamp(new Date().getTime()),bdPrice);
            burm.insert(zbur);//新增病床使用记录数据
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }


    /**
     * 查询住院病人的信息以及缴费详细
     * @return
     */
    public List<ZyPatientBase> selectPatientAndPay(){
       return pbm.selectPatientAndPay();
    }


    /**
     * 新增住院登记
     * @param patientBase 住院登记对象
     * @return
     */
    public boolean insertPatient(ZyPatientBase patientBase){
        try{
            //新增住院登记数据
            patientBase.setBdId(0L);//给零
            patientBase.setPtPrice(patientBase.getPtPayMoney());//将预交金额赋值给余额
            pbm.insert(patientBase);//新增


            //修改住院申请信息
            ZyInhospitalApply ha = new ZyInhospitalApply(patientBase.getInId(),2L);
            ham.updateById(ha);//根据住院申请编号修改状态

            //新增病人关系信息
            List<ZyContacts> ctaList = patientBase.getListContacts().isEmpty() ? null : patientBase.getListContacts();
            if(ctaList != null){
                int i = cs.insertContactsList(ctaList, patientBase.getPtNo());
                System.out.println("========================================="+i);
            }


            //新增一条缴费记录
            if(patientBase.getPtPayMoney() != null){
                ZyPay pay = new ZyPay(patientBase.getPtPayMoney(),new Timestamp(new Date().getTime()),patientBase.getPtNo(),patientBase.getSId());
                pm.insert(pay);//新增缴费记录
            }

            return true;


        }catch (Exception e){
            return false;
        }
    }







    /**
     * 修改住院病床位置
     * @return
     */
    public boolean PatientUpdateBed(PatientUpdateBedVo puvo){
        //=====================新增病床调换记录
        ZyBedChangeRecord bcr = new ZyBedChangeRecord(puvo.getBcCurrentBdId(),puvo.getBcLaterBdId(),new Timestamp(new Date().getTime()),puvo.getPtNo(),puvo.getSId(),puvo.getBcCause());
        bdrm.insert(bcr);


        //===================添加当前病床记录里面的结束时间
//        QueryWrapper<ZyBedUseRecord> qwb = new QueryWrapper<>();//条件构造器
//        qwb
//                .eq("pt_no",puvo.getPtNo())//根据住院号查询病床记录
//                .orderBy(true,false,"ur_use_date");
//        List<ZyBedUseRecord> list = burm.selectList(qwb);//查询
//
//        if(list.isEmpty()){//如果没有病床使用记录就不继续走
//            return false;
//        }
        ZyBedUseRecord bedUseRecord = selectBedUseRecord(puvo.getPtNo());//选中第一条数据
        if(bedUseRecord == null){
            return false;
        }

        ZyBedUseRecord zbr = new ZyBedUseRecord(bedUseRecord.getUrId(),new Timestamp(new Date().getTime()));
        burm.updateById(zbr);//修改

        //=================新增一条病床使用记录
        ZyBedUseRecord bed = new ZyBedUseRecord(puvo.getBcLaterBdId(),puvo.getPtNo(),new Timestamp(new Date().getTime()),puvo.getBdPrice());
        burm.insert(bed);//新增一条病床使用记录


        //===================修改之前的病床为可用状态以及将住院号设置为0
        ZyBed zyBed = new ZyBed(puvo.getBcCurrentBdId(),1L,0L);
        bm.updateById(zyBed);//修改

        //===================修改之后的病床为已入住状态以及将住院号设置到此病床里面
        ZyBed zyBeds = new ZyBed(puvo.getBcLaterBdId(),3L,puvo.getPtNo());
        bm.updateById(zyBeds);//修改



        //===============根据住院号修改病床编号
        ZyPatientBase pb = new ZyPatientBase(puvo.getPtNo(),puvo.getBcLaterBdId());
        pbm.updateById(pb);//根据住院编号修改病床编号

        return false;
    }
}
