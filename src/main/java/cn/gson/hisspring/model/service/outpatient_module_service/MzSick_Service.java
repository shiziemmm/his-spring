package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzSick_Mapper;
import cn.gson.hisspring.model.pojos.MzSick;
import cn.gson.hisspring.model.pojos.ZyBed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * 门诊-病人资料service
 */

@Service
@Transactional
public class MzSick_Service {
    @Autowired
    MzSick_Mapper mzSickMapper;

    //新增病人信息
    public void addMzSick(MzSick mzSick){
        if(mzSick!=null){
            //拿传过来的值去查询一遍看是否存在存在就修改。不存在就新增
            MzSick mzSick1 = mzSickMapper.selectById(mzSick.getSickIdCard());
            if(mzSick1==null){//如果不存在就新增
                mzSick.setSickTime(new Timestamp(System.currentTimeMillis()));//获取当前系统时间
                System.out.println(new Timestamp(System.currentTimeMillis()));
                mzSickMapper.insert(mzSick);
                System.err.println(mzSick.getSickNumber());
                System.out.println("新增");
                System.out.println(mzSick.getSickIdCard()+"----"+mzSick.getSickPhone());
            }else{
//                mzSickMapper.updateById(mzSick);
                System.out.println("修改");
            }
        }
    }

    //判断非空
    public boolean isNull(Object obj){
        if(obj == null || "".equals(obj.toString())){
            return true;
        }
        return false;
    }
}
