package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzCaseHistoryMapper;
import cn.gson.hisspring.model.pojos.MzCaseHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 住院病例
 */
@Service
@Transactional
public class CaseHistoryService {

    @Autowired
    MzCaseHistoryMapper historyMapper;//病历表


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
     * 根据病人
     */
}
