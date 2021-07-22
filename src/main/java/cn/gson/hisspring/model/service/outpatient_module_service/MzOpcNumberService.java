package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.StaffMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.TitleMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzOpcNumberMapper;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import cn.gson.hisspring.model.pojos.MzOpcNumber;
import cn.gson.hisspring.model.pojos.Title;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 排号表Service
 */
@Service
@Transactional
public class MzOpcNumberService {
    @Autowired
    MzOpcNumberMapper countMapper;
    @Autowired
    DepartmentKsMapper ksMapper;
    @Autowired
    TitleMapper titleMapper;
    public List<MzOpcNumber> selectMzOpcNumber(String ksName,String science){
        //查询科室
        QueryWrapper qw1 = new QueryWrapper();
        qw1.eq("ks_id",ksName);
        DepartmentKs ks = ksMapper.selectOne(qw1);
        //查询职称
        QueryWrapper qw2 = new QueryWrapper();
        qw2.eq("t_id",science);
        Title title = titleMapper.selectOne(qw2);
        if(title!=null){
            if(title.getTName().equals("主任医师") || title.getTName().equals("副主任医师")){
                science = "普通号";
            }else{
                science = "专家号";
            }
        }
        ksName = ks.getKsName();
        System.err.println(ksName);
        System.err.println(science);
        List<MzOpcNumber> mzOpcNumbers = countMapper.selectMzOpcNumber(ksName,science);
        return mzOpcNumbers;
    }
}
