package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationAnaesthesia;
import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.pojos.TjCodeProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
检查项目mapper
 */
@Mapper
@Repository
public interface TjprojectMapper extends BaseMapper<TjCodeProject> {
    List<TjCodeProject> selectAllTjObject(String seach);
    //删除
    @Delete("delete from Tj_code_project where index_id=#{indexId}")
    public void delet(Integer indexId);
    //查询套餐的检查项目
    @Select("SELECT b.check_id,b.check_name,b.check_pay,d.index_name,d.index_significance FROM tj_code_middle a\n" +
            "inner join tj_code_project b on a.check_id =b.check_id\n" +
            "inner join tj_code_index d on d.index_id =b.check_id\n" +
            "inner join tj_code_meal k on a.code_id=k.code_id\n" +
            "inner join tj_code_type c on k.code_type=c.type_id\n" +
            "where k.code_id=#{codeId}")
    List<TjCodeProject> inspect(Integer codeId );
}