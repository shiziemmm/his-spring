package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 权限科室表-Service（门诊部分）
 */
@Service
@Transactional
public class MzDepartmentKsService {
    @Autowired
    DepartmentKsMapper departmentKsMapper;//权限科室表mapper

    //查询所有科室表
    public List<DepartmentKs> selectDepartmentKs(){
        QueryWrapper qw  = new QueryWrapper<>();
        qw.eq("de_id",2);
        List<DepartmentKs> departmentKs = departmentKsMapper.selectList(qw);
        return departmentKs;
    }


}
