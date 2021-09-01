package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DeptDrugAllotMapper;
import cn.gson.hisspring.model.pojos.ZyDeptDrugAllot;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 科室库存调拨记录
 */
@Service
@Transactional
public class DeptDrugAllotService {

    @Autowired
    DeptDrugAllotMapper ddam;//科室库存调拨mapper

    /**
     * 根据科室编号查询凋敝信息
     * @param ksId
     * @return
     */
    public List<ZyDeptDrugAllot> selectByKsId(Long ksId){
        return ddam.selectByKsId(ksId);
    }


    public boolean addDeptDrugAllotFor(List<ZyDeptDrugAllot> list){
        int i = ddam.addDeptDrugAllotList(list);
        if(i > 0)
            return true;
        return false;
    }
}
