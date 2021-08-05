package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
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
    MzOpcNumberMapper countMapper; // 排号表mapper
    @Autowired
    DepartmentKsMapper ksMapper; //科室mapper
    @Autowired
    TitleMapper titleMapper; //职称表mapper
    @Autowired
    MzRegistrationService registrationService;//挂号表service



    //排号列表查询
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
            if(title.getTName().equals("教授") || title.getTName().equals("副教授")){
                science = "专家号";
            }else{
                science = "普通号";
            }
        }
        ksName = ks.getKsName();
        List<MzOpcNumber> mzOpcNumbers = countMapper.selectMzOpcNumber(ksName,science);
        return mzOpcNumbers;
    }

    // 过号
    public void jumpMark(MzOpcNumber opcNumber){
        Long aLong = registrationService.maxCount(opcNumber.getBnKsName(), opcNumber.getBnScience(), opcNumber.getBnTime());
        opcNumber.setBnCount(aLong+1);
        countMapper.updateById(opcNumber);//修改掉他的卡号
    }
    //删除排号
    public void delecteOpcCount(Long bnNumber){
        QueryWrapper qw = new QueryWrapper();
        qw.eq("bn_number",bnNumber);
        countMapper.delete(qw);
    }

}
