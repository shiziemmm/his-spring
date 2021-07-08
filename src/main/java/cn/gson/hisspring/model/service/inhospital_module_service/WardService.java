package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientBaseMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.WardMapper;
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
    public List<ZyWard> selectWardAllPage(){
        List<ZyWard> listWard = wdm.selectWardAllPage();
        for(ZyWard wd : listWard){
            if(!wd.getListBed().isEmpty()){//判断该病房下面是否有病床 防止报空指针
                for (ZyBed b : wd.getListBed()){
                    if(b.getBdIs() == 3){//判断是否能有病人入住  如果有病人入住的话就查询病人的信息
                        ZyPatientBase zpb = pbm.selectById(b.getPtNo());//根据病人编号查询病人信息
                        b.setPtName(zpb.getPtName());//将病人名称添加
                    }
                }
            }
        }
        return listWard.isEmpty() ? null : listWard;

    }
}
