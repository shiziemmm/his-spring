package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalCard_Mapper;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 门诊-诊疗卡Service
 */

@Service
public class MzMedicalCard_Service {
    @Autowired
    MzMedicalCard_Mapper mzMedicalCardMapper;

//    public int addMzMedicalCard(MzMedicalCard mzMedicalCard){
//        mzMedicalCard.setMcIdCard();
//        int insert = mzMedicalCardMapper.insert(mzMedicalCard);
//    }
}
