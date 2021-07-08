package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentMapper;
import cn.gson.hisspring.model.pojos.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper ds;
    //部门查询
    public List<Department> selectList(){
        return ds.selectList(null);
    }
    //部门新增
    public int  add(Department dept){
        return ds.insert(dept);
    }
    //部门修改
    public int upa(Department dept){
        return ds.updateById(dept);
    }
    //部门删除
    public int dete(long id){
        return ds.deleteById(id);
    }
   public List<Department> selectlike(Department dept){
        return ds.selectlike(dept);
    }
}
