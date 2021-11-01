package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzAlterLoseMapper;
import cn.gson.hisspring.model.pojos.MzAlterLose;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 门诊-修改&补卡记录表Service
 */
@Service
@Transactional
public class MzAlterLoseService {
    @Autowired
    MzAlterLoseMapper alterLose;

    //查询所有加like查询
    public List<MzAlterLose> allLikeAlterLose(String like) {
        List<MzAlterLose> lose = alterLose.selectMzAlterLose(like);
        return lose;
    }

}
