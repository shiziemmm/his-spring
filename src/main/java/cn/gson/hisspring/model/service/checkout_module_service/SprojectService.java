package cn.gson.hisspring.model.service.checkout_module_service;

import cn.gson.hisspring.model.mapper.checkout_module_mapper.AnaeMapper;
import cn.gson.hisspring.model.mapper.checkout_module_mapper.SprojectMapper;
import cn.gson.hisspring.model.pojos.*;
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
    @Autowired
    AnaeMapper ana;//麻醉项目mapper
    //所有手术项目
    public List<SsOperationProject> allProject(){
        List<SsOperationProject> listsp = sproject.allProject();
        return listsp;
    }
    //单个手术项目详情
    public List<SsOperationProject> singeProject(Integer projectId){
        List<SsOperationProject> listssp = sproject.singleProject(projectId);
        List<SsOperationAnaesthesia> listmp = ana.Ana(projectId);
        return listssp;
    }
    //单个手术项目麻醉详情
    public List<SsOperationAnaesthesia> AnaProject(Integer projectId){
        List<SsOperationAnaesthesia> listmp = ana.Ana(projectId);
        return listmp;
    }
    //所有麻醉
    public List<SsOperationAnaesthesia> allAnaesthesia(){
        List<SsOperationAnaesthesia> listmz = ana.allAnaesthesia();
        return listmz;
    }
}
