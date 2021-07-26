package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinDetailsMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinMapper;
import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.StaffMapper;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 医嘱service
 */
@Service
public class DoctorEnjoinService {

    @Autowired
    DoctorEnjoinMapper dem;//医嘱mapper

    @Autowired
    DoctorEnjoinDetailsMapper dedm;//医嘱详情表mapper

    @Autowired
    StaffMapper sm;//员工mapper


    /**
     * 添加医嘱以及医嘱详表数据
     */
    public boolean addDoctorEnjoin(ZyDoctorEnjoin zyDoctorEnjoin){
        try{
            //===================================新增医嘱主表
            dem.insert(zyDoctorEnjoin);

            System.err.println(zyDoctorEnjoin.getDeId());


            //===================================新增医嘱详情表
            dedm.insertDeDetailsFor(zyDoctorEnjoin.getDedList(),zyDoctorEnjoin.getDeId());//循环新增
            return true;
        }catch (Exception e){
            return false;
        }
    }


}
