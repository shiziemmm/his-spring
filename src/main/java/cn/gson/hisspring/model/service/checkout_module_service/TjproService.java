package cn.gson.hisspring.model.service.checkout_module_service;

import cn.gson.hisspring.model.mapper.checkout_module_mapper.*;
import cn.gson.hisspring.model.pojos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
体检项目service
 */
@Service
public class TjproService {
    @Autowired//检查项目
    TjprojectMapper major;
    @Autowired//套餐类型
    TJTypeMapper fix;
    @Autowired//指标
    TjIndexMapper sed;
    @Autowired//套餐表mapper
    TjmealMapper crd;
    @Autowired//中间表mapper
    TjMiddleMapper midd;
//检查项目模糊查询与传参
    public List<TjCodeProject> selectAllTjObject(String seach){
        List<TjCodeProject> listjc = major.selectAllTjObject(seach);
        return  listjc;
    }
    //体检套餐模糊查询与传参
    public List<TjCodeMeal> selectAllTjMeal(String checkIndex,String codeName,String codeType){
        List<TjCodeMeal> listm = crd.selectAllTjMeal(checkIndex,codeName,codeType);
        return  listm;
    }
    //体检套餐类型
    public List<TjCodeType> allType(){
        List<TjCodeType> listfix= fix.alltype();
        return  listfix;
    }
    //体检套餐所含检查项目
    public List<TjCodeProject> selectTjpro(Integer codeId){
        List<TjCodeProject> listm = major.inspect(codeId);
        return  listm;
    }
    /**
     * 新增修改套惨
     * @return
     */
    public boolean tjmealUpdate(TjCodeMeal mroj){
        int is = 0;//判断是否新增成功
        if(mroj.getCodeId() == 0){//新增
            is = crd.insert(mroj);
            System.out.println("新增编号"+mroj.getCodeId());
            crd.insertTjmid(mroj.getTjAn(),mroj.getCodeId());
        }else{//修改
//            sproject.delet((int) proj.getProjectId());
            //删除原本中间表
            midd.delete((int) mroj.getCodeId());
//            重新新增中间表
            crd.insertTjmid(mroj.getTjAn(),mroj.getCodeId());
            is = crd.updateById(mroj);
        }

        return is == 0?false:true;
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
