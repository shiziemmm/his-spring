package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.InHospitalApplyMapper;
import cn.gson.hisspring.model.pojos.ZyInhospitalApply;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 */
@Service
public class InHospitalApplyService {

    @Autowired
    InHospitalApplyMapper ham;

    /**
     * 查询所有未审核的住院申请
     * @return
     */
    public List<ZyInhospitalApply> selectHspApplyByInIs(){
        List<ZyInhospitalApply> list = ham.selectHspApplyByInIs("1");//查询未审核的住院申请信息
        return list.isEmpty() ? null : list;
    }


    /**
     * 根据住院申请编号修改住院申请状态为取消状态
     * @return
     */
    public boolean HspApplyByInIdUpdateInIs(Long inId){
        ZyInhospitalApply hos = new ZyInhospitalApply(inId,3L);

       int is = ham.updateById(hos);//修改

        return is > 0;
    }
}
