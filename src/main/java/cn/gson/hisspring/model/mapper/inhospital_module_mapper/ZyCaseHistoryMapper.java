package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.MzCaseHistory;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ZyCaseHistoryMapper extends BaseMapper<MzCaseHistory> {

    List<MzCaseHistory> selectCaseByWhere(SelectExecuteVo selectExecuteVo);

    List<Staff> selectCaseStaff(Long sickNumber);

}
