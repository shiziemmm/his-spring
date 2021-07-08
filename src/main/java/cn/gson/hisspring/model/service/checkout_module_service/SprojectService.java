package cn.gson.hisspring.model.service.checkout_module_service;

import cn.gson.hisspring.model.mapper.checkout_module_mapper.SprojectMapper;
import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.pojos.ZyBed;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import cn.gson.hisspring.model.pojos.ZyWard;
import com.github.pagehelper.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SprojectService {
    @Autowired
    SprojectMapper sproject;//手术项目mapper

    public List<SsOperationProject> allProject(){
        List<SsOperationProject> listsp = sproject.allProject();
        return listsp;

    }
}
