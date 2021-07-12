package cn.gson.hisspring.model.service.jurisdiction_module_service;

import cn.gson.hisspring.model.mapper.jurisdiction_module_mapper.DepartmentKsMapper;
import cn.gson.hisspring.model.pojos.DepartmentKs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentKsService {
    @Autowired
    DepartmentKsMapper d;

    public List<DepartmentKs> selectlist(){
        return d.selectlist();
    };

    public int addlist(DepartmentKs departmentKs){
        return d.insert(departmentKs);
    }
    public int upalist(DepartmentKs departmentKs){
        return d.updateById(departmentKs);
    }
}
