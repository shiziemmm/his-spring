package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.DoctorEnjoinExecuteRecordMapper;
import cn.gson.hisspring.model.mapper.inhospital_module_mapper.PatientCostMapper;
import cn.gson.hisspring.model.pojos.ZyDoctorEnjoinExecuteRecord;
import cn.gson.hisspring.model.pojos.pojos_vo.PatientCostVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
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

    @Autowired
    DoctorEnjoinExecuteRecordMapper deerm;//医嘱执行记录

    /**
     * 根据病人住院号查询所有消费记录
     * @param ptNo 住院编号
     * @return
     */
    public List<PatientCostVo> selectCostByPtNo(Long ptNo, String text, SelectExecuteVo selectExecuteVo){
        if(text != null) {
            return pcm.selectPayByWhere(ptNo,text,selectExecuteVo.getStartDate(),selectExecuteVo.getEndDate(),selectExecuteVo.getSIdArr());
        }else{
            return pcm.selectPayAll(ptNo,selectExecuteVo.getStartDate(),selectExecuteVo.getEndDate(),selectExecuteVo.getSIdArr());
        }
    }


    /**
     * 根据病人住院号查询所有消费记录(出院版)
     * @param ptNo 住院编号
     * @return
     */
    public List<PatientCostVo> selectCostByPtNoDischarge(Long ptNo, String text, SelectExecuteVo selectExecuteVo){
            return pcm.selectPayByWhereDischarge(ptNo,text,selectExecuteVo.getStartDate(),selectExecuteVo.getEndDate(),selectExecuteVo.getSIdArr());
    }

    /**
     * 查询出所有不同的费用名称
     * @return
     */
    public List<ZyDoctorEnjoinExecuteRecord> selectCostName(){
        QueryWrapper<ZyDoctorEnjoinExecuteRecord> qwc = new QueryWrapper<ZyDoctorEnjoinExecuteRecord>().groupBy("der_is").notIn("der_is",1);
        return deerm.selectList(qwc);
    }

}
