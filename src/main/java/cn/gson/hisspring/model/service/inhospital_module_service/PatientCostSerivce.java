package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientCostMapper;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientCostVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *病人费用明细service
 */
@Service
public class PatientCostSerivce {
    @Autowired
    PatientCostMapper pcm;//病人消费记录

    /**
     * 根据病人住院号查询所有消费记录
     * @param ptNo 住院编号
     * @return
     */
    public List<PatientCostVo> selectCostByPtNo(Long ptNo,String text){
        QueryWrapper<PatientCostVo> qwc = new QueryWrapper<PatientCostVo>().eq("pt_no",ptNo).orderBy(true,false,"pcd_date");
        if(text != null){
            qwc.eq("pcd_cause",text);
        }

        List<PatientCostVo> patientCostVos = pcm.selectList(qwc);
        return patientCostVos;
    }

}
