package cn.gson.hisspring.model.service.checkout_module_service;

import cn.gson.hisspring.model.mapper.checkout_module_mapper.SprojectMapper;
import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.pojos.ZyBed;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SprojectService {
    @Autowired
    SprojectMapper sproject;
//    public Map<String,Object> allProject(Integer pageNo, Integer size){
//        Map<String,Object> map = new HashMap<>();
//        //分页查询
//        Page<Object> page = PageHelper.startPage(pageNo, size);
//        map.put("rows",sproject.allProject());
//        map.put("total",page.getTotal());
//        return map;
//    }
    public List<SsOperationProject> allProject(){
        Page<SsOperationProject> page = new Page<>(1,2);
        return sproject.allProject(page);
    }
}
