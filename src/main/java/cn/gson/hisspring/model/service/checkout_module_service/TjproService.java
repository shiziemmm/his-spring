package cn.gson.hisspring.model.service.checkout_module_service;

import cn.gson.hisspring.model.mapper.checkout_module_mapper.TjIndexMapper;
import cn.gson.hisspring.model.mapper.checkout_module_mapper.TjmealMapper;
import cn.gson.hisspring.model.mapper.checkout_module_mapper.TjprojectMapper;
import cn.gson.hisspring.model.pojos.TjCodeIndex;
import cn.gson.hisspring.model.pojos.TjCodeMeal;
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
    @Autowired
    TjIndexMapper sed;
    @Autowired
    TjmealMapper crd;
//检查项目模糊查询与传参
    public List<TjCodeProject> selectAllTjObject(String seach){
        List<TjCodeProject> listjc = major.selectAllTjObject(seach);
        return  listjc;
    }
    //检查项目模糊查询与传参
    public List<TjCodeMeal> selectAllTjMeal(String search){
        List<TjCodeMeal> listm = crd.selectAllTjMeal(search);
        return  listm;
    }

    /**
     * 新增修改检查项目
     * @return
     */
    public boolean tprojectUpdate(TjCodeProject troj){
        int is = 0;//判断是否新增成功
        if(troj.getCheckId() == 0){//新增
            TjCodeIndex tjCodeIndex = new TjCodeIndex();

            sed.insert(troj.getTjCodeIndex());
            System.err.println("新增进去"+troj.getTjCodeIndex().getIndexId());
            troj.setIndexId(troj.getTjCodeIndex().getIndexId());
            System.out.println(troj.getTjCodeIndex().getIndexId());
            is = major.insert(troj);
        }else{//修改
            sed.updateById(troj.getTjCodeIndex());
            is = major.updateById(troj);
        }

        return is == 0?false:true;
    }
    /**
     * 新增修改检查项目
     * @return
     */
    //检查项目删除
    public void delet(Integer  index){
        sed.deleteById(index);
        major.delet(index);
    }
//指标表查询所有
    public List<TjCodeIndex> allIndex(){
        List<TjCodeIndex> listzb =sed.allIndex();
        return  listzb;
    }
}
