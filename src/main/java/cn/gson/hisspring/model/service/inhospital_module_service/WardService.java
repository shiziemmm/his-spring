package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.WardMapper;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.ZyBed;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import cn.gson.hisspring.model.pojos.ZyWard;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.dreamyoung.mprelation.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 病房service层
 */
@Service
public class WardService{
    @Autowired
    WardMapper wdm;//病房mapper
    @Autowired
    PatientBaseMapper pbm;

    /**
     * 查询所有病房
     * @return
     */
    public List<ZyWard> selectWardAllPage(String search, Staff staff){
//        QueryWrapper<ZyWard> qw = new QueryWrapper<ZyWard>().eq("ks_id",staff.getKsId());
//        wdm.selectList(qw);
        List<ZyWard> listWard = wdm.selectWardAllPage(search,staff.getKsId().toString());
        for(ZyWard wd : listWard){
            if(!wd.getListBed().isEmpty()){//判断该病房下面是否有病床 防止报空指针
                int count = 0;//病房病人数量
                for (ZyBed b : wd.getListBed()){
                    if(b.getBdIs() == 3){//判断是否能有病人入住  如果有病人入住的话就查询病人的信息
                        count++;//数量加一
                        QueryWrapper<ZyPatientBase> qwBed = new QueryWrapper<>();
                        qwBed.eq("pt_no",b.getPtNo());//根据住院号查询病人信息
                        qwBed.orderBy(true,false,"pt_no");
                        ZyPatientBase zpb = pbm.selectOne(qwBed);//根据病人编号查询病人信息
                        b.setPtName(zpb.getPtName());//将病人名称添加
                    }
                }
                wd.setBedCount(count);
            }
        }
        return listWard.isEmpty() ? null : listWard;
    }

    /**
     * 新增病房
     * @return
     */ 
    public boolean wardInsertOrUpdate(ZyWard ward){
        int is = 0;//判断是否新增成功
        if(ward.getWdId() == 0){//新增
            is = wdm.insert(ward);
        }else{//修改
            is = wdm.updateById(ward);
        }
        return is == 0?false:true;
    }

    /**
     * 根据科室查询病房信息
     */
    public List<ZyWard> selectWardByKsId(String ksId){
        List<ZyWard> list = wdm.selectWardAllPage("",ksId);

        return list.isEmpty() ? null : list;
    }

}
