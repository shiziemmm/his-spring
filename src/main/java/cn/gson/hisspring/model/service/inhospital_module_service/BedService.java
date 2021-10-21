package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.BedMapper;
import cn.gson.hisspring.model.pojos.ZyBed;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BedService {

    @Autowired
    BedMapper bm;

    /**
     * 判断病房床名称是否重复
     */
    public boolean selectBdNameRepetition(String bdName){
        QueryWrapper<ZyBed> zyBedQueryWrapper = new QueryWrapper<ZyBed>().eq("bd_name",bdName);
        List<ZyBed> zyBeds = bm.selectList(zyBedQueryWrapper);
        if (zyBeds.isEmpty()){
            return false;
        }
        return true;

    }


    /**
     * 新增或者修改病床方法
     * @param bed
     * @return
     */
    public boolean bedAddOrUpdate(ZyBed bed){
        int is = 0;//判断是否新增成功
        if(bed.getBdId() == 0){//新增
            is = bm.insert(bed);
        }else{//修改
            is = bm.updateById(bed);
        }
        return is == 0?false:true;
    }


    /**
     * 根据病床编号修改病床状态
     * @param bdId 病床编号
     * @param bdIs 病床状态 1表示可用  2表示停用  3表示已有病人入住
     * @return
     */
    public boolean bedUpdateBdIs(long bdId,long bdIs){
        ZyBed bed = new ZyBed(bdId,bdIs);
        int i = bm.updateById(bed);
        return i > 0 ? true : false;
    }

    /**
     * 根据病房编号查询病床
     * @param wdId 病房编号
     */
    public List<ZyBed> bedSelectByWdId(long wdId){
        QueryWrapper<ZyBed> qw = new QueryWrapper<>();
        qw.eq("wd_id",wdId);
        List<ZyBed> list = bm.selectList(qw);
        return list.isEmpty() ? null : list;
    }

}
