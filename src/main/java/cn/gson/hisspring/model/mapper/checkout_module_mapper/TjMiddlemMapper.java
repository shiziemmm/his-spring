package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.TjManMiddle;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;

//体检人员中间mapper
@Mapper
public interface TjMiddlemMapper extends BaseMapper<TjManMiddle> {
    //    删除中间表根据编号
    @Delete("delete from tj_man_middle where man_id=#{manId}")
    public void delet(Integer manId);
}
