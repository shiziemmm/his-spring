package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.ZyBedChangeRecord;
import cn.gson.hisspring.model.pojos.ZyChangeDeptRecord;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 查询所有病人记录mapper
 */
@Mapper
public interface AllRecordMapper {

    List<ZyBedChangeRecord> seltzychangebedrecord(SelectExecuteVo selectExecuteVo);

    List<ZyChangeDeptRecord> seltzychangeksrecord(SelectExecuteVo selectExecuteVo);

}
