package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.MzSick;
import cn.gson.hisspring.model.pojos.SsOperationProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SprojectMapper extends BaseMapper<SsOperationProject> {
    @Select("select * from SsOperationProject")
    public List<SsOperationProject> allProject(Page<SsOperationProject> page);
}
