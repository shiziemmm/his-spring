package cn.gson.hisspring.model.service.checkout_module_service;

import cn.gson.hisspring.model.mapper.checkout_module_mapper.TjprojectMapper;
import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.pojos.TjCodeProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
体检项目service
 */
@Service
public class TjproService {
    @Autowired
    TjprojectMapper major;
//检查项目模糊查询与传参
    public List<TjCodeProject> selectAllTjObject(String seach){
        List<TjCodeProject> listjc = major.selectAllTjObject(seach);
        return  listjc;
    }

    /**
     * 新增手术项目
     * @return
     */
    public boolean tprojectUpdate(TjCodeProject troj){
        int is = 0;//判断是否新增成功
        if(troj.getCheckId() == 0){//新增
            is = major.insert(troj);
        }else{//修改
//
            is = major.updateById(troj);
        }

        return is == 0?false:true;
    }
}
