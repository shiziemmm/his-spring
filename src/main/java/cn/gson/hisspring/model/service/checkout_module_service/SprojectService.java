package cn.gson.hisspring.model.service.checkout_module_service;

import cn.gson.hisspring.model.mapper.checkout_module_mapper.*;
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
    @Autowired
    SsApplyMapper ssq;//手术申请mapper
    @Autowired
    SsDetailsMapper ssd;//手术记录mapper
    //所有手术项目
    public List<SsOperationProject> allProject(){
        List<SsOperationProject> listsp = sproject.allProject();
        return listsp;
    }
    //所有手术室
    public List<SsOperationRoom> allSroom(String seach){
        List<SsOperationRoom> listss = sss.allSroom(seach);
        return listss;
    }
    //所有手术记录
    public List<SsOperationDetails> allSdetails(String seach){
        List<SsOperationDetails> listss = ssd.selectAllsDetails(seach);
        return listss;
    }
    //所有手术申请
    public List<SsOperationApply> allSApply(String seach){
        List<SsOperationApply> listss = ssq.selectSsApply(seach);
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
    //修改手术室状态
    public void updazt(Integer operationZt,Integer operationId){
        sss.updSroom(operationZt,operationId);
    }
    /**
     * 新增修改手术室
     * @return
     */
    public boolean sssUpdate(SsOperationRoom proj){
        int is = 0;//判断是否新增成功
        if(proj.getOperationId() == 0){//新增
            sss.insert(proj);
        }else{//修改
            is = sss.updateById(proj);
        }

        return is == 0?false:true;
    }
    /**
     * 新增修改手术申请
     * @return
     */
    public boolean ssqUpdate(SsOperationApply proj){
        int is = 0;//判断是否新增成功
        if(proj.getOperationId() == 0){//新增
            ssq.insert(proj);
        }else{//修改
            is = ssq.updateById(proj);
        }
        return is == 0?false:true;
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
