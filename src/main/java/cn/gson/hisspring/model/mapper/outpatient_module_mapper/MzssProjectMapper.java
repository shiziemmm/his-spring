package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 门诊 - 调用手术的mapper
 */
@Mapper
public interface MzssProjectMapper extends BaseMapper<SsOperationProject> {
    /**
     * 查询所有的手术项目
     * @param text
     * @return
     */
    public List<SsOperationProject> selectMzssProject(String text);
}
