package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzSickMapper;
import cn.gson.hisspring.model.pojos.MzSick;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/**
 * 门诊-病人资料service
 */

@Service
@Transactional
public class MzSickService {
    @Autowired
    MzSickMapper mzSickMapper;
    //新增病人信息
    public void addMzSick(MzSick mzSick){
        if(mzSick!=null){
            MzSick mzSick1 = mzSickMapper.selectById(mzSick.getSickIdCard());
            if(!mzSick.getSickIdCard().equals(mzSick1.getSickIdCard())){//如果不存在就新增
                mzSickMapper.insert(mzSick);
                System.out.println("新增");
            }else{
                System.out.println("修改");
            }
        }
    }
}
