package cn.gson.hisspring.model.service.inhospital_module_service;

import cn.gson.hisspring.model.mapper.inhospital_module_mapper.AllRecordMapper;
import cn.gson.hisspring.model.pojos.ZyBedChangeRecord;
import cn.gson.hisspring.model.pojos.ZyChangeDeptRecord;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 查询病人所有的记录service
 */
@Service
@Transactional
public class AllRecordService {

    @Autowired
    AllRecordMapper arm;

    /**
     * 根据病人编号查询转科记录
     *
     * @param selectExecuteVo
     * @return
     */
    public List<ZyChangeDeptRecord> seltZyChangeKsRecord(SelectExecuteVo selectExecuteVo) {
        return arm.seltzychangeksrecord(selectExecuteVo);
    }


    /**
     * 根据病人编号查询转病房记录
     *
     * @param selectExecuteVo
     * @return
     */
    public List<ZyBedChangeRecord> seltZyChangeBedRecord(SelectExecuteVo selectExecuteVo) {
        return arm.seltzychangebedrecord(selectExecuteVo);
    }

}
