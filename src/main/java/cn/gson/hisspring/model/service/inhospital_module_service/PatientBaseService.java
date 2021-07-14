package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.BedChangeRecordMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.BedMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.BedUseRecordMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientUpdateBedVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 查询住院登记里面没有分配病床的信息
     * @return
     */
    public List<ZyPatientBase> selectPatientNoBed(){
        QueryWrapper<ZyPatientBase> qw = new QueryWrapper<>();
        qw
          .eq("bd_id",0)//查询病床编号为空的 0就是为空
          .isNull("pt_out_date")//查询出院日期为空的
        ;

        List<ZyPatientBase> list = pbm.selectList(qw);

        for (ZyPatientBase pd : list) {
            if(pd.getKsId() != null){
                QueryWrapper<DepartmentKs> qwk = new QueryWrapper<>();
                qwk.eq("ks_id",pd.getKsId());//根据科室编号查询
                DepartmentKs dks = dkm.selectOne(qwk);
                pd.setKsName(dks.getKsName());//将科室名称放入住院登记里面去
            }
        }
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
     * 修改住院病床位置
     * @return
     */
    public boolean PatientUpdateBed(PatientUpdateBedVo puvo){
        //=====================新增病床调换记录
        ZyBedChangeRecord bcr = new ZyBedChangeRecord(puvo.getBcCurrentBdId(),puvo.getBcLaterBdId(),new Timestamp(new Date().getTime()),puvo.getPtNo());
        bdrm.insert(bcr);


        //===================添加当前病床记录里面的结束时间
        QueryWrapper<ZyBedUseRecord> qwb = new QueryWrapper<>();//条件构造器
        qwb
                .eq("pt_no",puvo.getPtNo())//根据住院号查询病床记录
                .orderBy(true,false,"ur_use_date");
        List<ZyBedUseRecord> list = burm.selectList(qwb);//查询

        if(list.isEmpty()){//如果没有病床使用记录就不继续走
            return false;
        }
        ZyBedUseRecord bedUseRecord = list.get(0);//选中第一条数据

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
