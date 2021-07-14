package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.StaffMapper;
import cn.gson.hisspring.model.pojos.Staff;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService{

    @Autowired
    StaffMapper sm;

    /**
     * 根据科室编号查询所有员工
     * @return
     */
    public List<Staff> selectStaffAll(Integer ksId){
        QueryWrapper<Staff> qw = new QueryWrapper<>();
        qw.eq("ks_id",ksId);//根据科室编号查询
        return sm.selectList(qw);
    }

}
