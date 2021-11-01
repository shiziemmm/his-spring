package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.StaffMapper;
import cn.gson.hisspring.model.pojos.Staff;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    @Autowired
    StaffMapper sm;

    /**
     * 根据科室编号查询所有员工
     *
     * @return
     */
    public List<Staff> selectStaffAll(Integer ksId) {
        QueryWrapper<Staff> qw = new QueryWrapper<>();
        qw.eq("ks_id", ksId);//根据科室编号查询
        return sm.selectList(qw);
    }

    /*
    查询所有员工信息
     */
    public List<Staff> selectALl() {
        return sm.selectALl();
    }

    ;

    //新增元员工
    public int addStaff(Staff staff) {
        return sm.insert(staff);
    }

    //修改员工信息
    public int upa(Staff staff) {
        return sm.updateById(staff);
    }

    //根据科室查员工
    public List<Staff> selectksId(long ksId) {
        return sm.selectksId(ksId);
    }

    public int upa(long id) {
        return sm.upa(id);
    }

    public List<Staff> selectRole(long uId) {
        return sm.selectRole(uId);
    }

}
