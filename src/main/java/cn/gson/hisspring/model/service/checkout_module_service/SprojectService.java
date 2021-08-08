package cn.gson.hisspring.model.service.checkout_module_service;

import cn.gson.hisspring.model.mapper.checkout_module_mapper.AnaeMapper;
import cn.gson.hisspring.model.mapper.checkout_module_mapper.SchangeMapper;
import cn.gson.hisspring.model.mapper.checkout_module_mapper.SprojectMapper;
import cn.gson.hisspring.model.mapper.checkout_module_mapper.SsRoomMapper;
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
    @Autowired
    SchangeMapper mid;//麻醉中间项目mapper
    @Autowired
    SsRoomMapper sss;//手术室mapper
    //所有手术项目
    public List<SsOperationProject> allProject(){
        List<SsOperationProject> listsp = sproject.allProject();
        return listsp;
    }
    //所有手术室
    public List<SsOperationRoom> allSroom(){
        List<SsOperationRoom> listss = sss.allSroom();
        return listss;
    }
    //单个手术项目详情
    public List<SsOperationProject> singeProject(Integer projectId){
        List<SsOperationProject> listssp = sproject.singleProject(projectId);
        List<SsOperationAnaesthesia> listmp = ana.Ana(projectId);
        return listssp;
    }
    //单个手术项目表
    public List<SsOperationProject> aloneProject(Integer projectId){
        List<SsOperationProject> listalone = sproject.aloneProject(projectId);
        return listalone;
    }
    /**
     * 新增修改手术项目
     * @return
     */
    public boolean projectUpdate(SsOperationProject proj){
        int is = 0;//判断是否新增成功
        if(proj.getProjectId() == 0){//新增
            is = sproject.insert(proj);
            proj.getSsAn();
            System.out.println("新增编号"+proj.getProjectId());
            sproject.insertSsObject(proj.getProjectId(),proj.getSsAn());
        }else{//修改
//            sproject.delet((int) proj.getProjectId());
            mid.delet((int) proj.getProjectId());
            sproject.insertSsObject(proj.getProjectId(),proj.getSsAn());
            is = sproject.updateById(proj);
        }

        return is == 0?false:true;
    }
    //手术项目删除
    public void delet(Integer  projectId){
         sproject.delet(projectId);
    }

    //单个手术项目麻醉详情
    public List<SsOperationAnaesthesia> AnaProject(Integer projectId){
        List<SsOperationAnaesthesia> listmp = ana.Ana(projectId);
        return listmp;
    }
    //模糊查询手术项目
    public List<SsOperationProject> selectAllSsObject(String input){
        List<SsOperationProject> listap = sproject.selectAllSsObject(input);
        return  listap;
    }
    //所有麻醉
    public List<SsOperationAnaesthesia> allAnaesthesia(){
        List<SsOperationAnaesthesia> listmz = ana.allAnaesthesia();
        return listmz;
    }

}
