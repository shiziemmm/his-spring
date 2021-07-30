package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.pojos.TjCodeMan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

//体检人员mapper
@Mapper
public interface TjManMapper extends BaseMapper<TjCodeMan> {
    //体检人员查询
    List<TjCodeMan> selectAllMan(Integer manState,String sermen);
    //修改体检人员时间
    @Update("update tj_code_man set man_time=#{manTime} where man_id=#{manId}")
    public void  updTjman(String manTime,Integer manId);
    //批量新增体检人员项目中间表
    int insertTjman(long manId,List<Integer> listArr);
    //状态修改
    @Update("update tj_code_man set man_state=#{manState} where man_id=#{manId}")
    public void updatezt(Integer manState,Integer manId);
}
