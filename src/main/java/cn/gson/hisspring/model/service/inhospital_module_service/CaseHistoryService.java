package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.ZyCaseHistoryMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzCaseHistoryMapper;
import cn.gson.hisspring.model.pojos.MzCaseHistory;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 住院病例
 */
@Service
@Transactional
public class CaseHistoryService {

    @Autowired
    ZyCaseHistoryMapper historyMapper;//病历表


    /**
     * 新增病人病例
     * @param mzCaseHistory
     * @return
     */
    public boolean addCaseHistory(MzCaseHistory mzCaseHistory){
        int insert = historyMapper.insert(mzCaseHistory);
        if(insert > 0)
            return true;
        return false;
    }

    /**
     * 根据病人的信息编号查询所有的病历
     */
    public List<MzCaseHistory> selectBySickNumberPtNoCase(SelectExecuteVo selectExecuteVo){
        return historyMapper.selectCaseByWhere(selectExecuteVo);
    }

    /**
     * 根据病人信息编号查询出所有开病历的医生
     */
    public List<Staff> selectCaseStaff(Long sickNumber){
        return historyMapper.selectCaseStaff(sickNumber);
    }

}
