package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.BedMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.BedUseRecordMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import cn.gson.hisspring.model.pojos.ZyBed;
import cn.gson.hisspring.model.pojos.ZyBedUseRecord;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 住院登记service层
 */
@Service
public class PatientBaseService {

    @Autowired
    PatientBaseMapper pbm;//住院登记mapper

    @Autowired
    DepartmentKsMapper dkm;//科室mapper

    @Autowired
    BedUseRecordMapper burm;//病床使用记录mapper

    @Autowired
    BedMapper bm;//病床mapper

    /**
     * 查询住院登记里面没有分配病床的信息
     * @return
     */
    public List<ZyPatientBase> selectPatientNoBed(){
        QueryWrapper<ZyPatientBase> qw = new QueryWrapper<>();
        qw
          .isNull("bd_id")//查询病床编号为空的
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
            ZyBedUseRecord zbur = new ZyBedUseRecord(bdId,ptNo,new Timestamp(new Date().getTime()),null,bdPrice);
            burm.insert(zbur);//新增病床使用记录数据
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }

    }
}
