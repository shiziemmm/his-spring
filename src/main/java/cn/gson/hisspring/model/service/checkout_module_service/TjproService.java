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
    @Autowired//体检项目套餐中间表mapper
    TjMiddleMapper midd;
    @Autowired//体检人员表mapper
    TjManMapper man;
    @Autowired//体检项目人员中间表mapper
    TjMiddlemMapper sen;
    @Autowired//体检结果表mapper
    TjResultMapper ent;
    @Autowired
    MzMedicalCardMapper1 car;//诊疗卡体检用mapper
//检查项目模糊查询与传参
    public List<TjCodeProject> selectAllTjObject(String seach,Integer checkTpye){
        List<TjCodeProject> listjc = major.selectAllTjObject(seach,checkTpye);
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
    //体检人员模糊查询与传参
    public List<TjCodeMan> selectAllman(Integer manState,String sermen){
        List<TjCodeMan> listman = man.selectAllMan(manState,sermen);
        System.out.println(listman);
        return  listman;
    }
    //查体检人员所含项目
    public List<TjCodeProject> selectAlonMm(Integer manId){
        List<TjCodeProject> listman = major.selectAlonMp(manId);
        System.out.println(listman);
        return  listman;
    }
    //体检结果传参
    public List<TjManResult> AllRes(Integer manId){
        List<TjManResult> listres = ent.allmresult(manId);
        System.out.println(listres);
        return  listres;
    }
    //根据编号查询诊疗卡
    public List<MzMedicalCard> alomCaed(String mcIdCard){
        List<MzMedicalCard> listcard = car.allmzmidCard(mcIdCard);
        System.out.println(listcard);
        return  listcard;
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
     * 新增修改体检人员
     * @return
     */
    public boolean tjmanUpdate(TjCodeMan manj){
        int is = 0;//判断是否新增成功
        if(manj.getManId() != 0){//新增
            //修改
            //删除原本中间表
            sen.delet(manj.getManId().intValue());
//            重新新增中间表
            man.insertTjman(manj.getManId(),manj.getJcXm());
            is = man.updateById(manj);
        }else{
            is = man.insert(manj);
            System.out.println("新增编号"+manj.getManId());
            man.insertTjman(manj.getManId(),manj.getJcXm());
        }

        return is == 0?false:true;
    }
    //    批量修改体检人员
    public void updTjman(String manTime,Integer manId){
        int is = 0;//判断是否修改成功
        man.updTjman(manTime,manId);
    }

    //修改体检人员状态
    public void updamzt(Integer manState,Integer manId){
        man.updatezt(manState,manId);
    }
    //修改体检人员医生建议
    public void updamanY(String manProposal,Integer manId){
        man.updTjmanY(manProposal,manId);
    }
    //修改诊疗卡金额根据身份证
    public void updMoney(Integer mcBalance,String mcIdCard){car.updMoney(mcBalance,mcIdCard);}
//    批量新增结果
    public boolean inserjg(List listArr){
        int is = 0;//判断是否新增成功
        listArr.forEach(v->{
            System.err.println(v);
        });
        is=ent.insertTjmres(listArr);
        return is == 0?false:true;
    }

    /**
     * 新增修改检查项目
     * @return
     */
    public boolean tprojectUpdate(TjCodeProject troj){
        int is = 0;//判断是否新增成功
        if(troj.getCheckId() == 0){//新增
//            TjCodeIndex tjCodeIndex = new TjCodeIndex();
//            sed.insert(troj.getTjCodeIndex());
//            System.err.println("新增进去"+troj.getTjCodeIndex().getIndexId());
//            troj.setIndexId(troj.getTjCodeIndex().getIndexId());
//            System.out.println(troj.getTjCodeIndex().getIndexId());
            is = major.insert(troj);
        }else{//修改
//            sed.updateById(troj.getTjCodeIndex());
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
