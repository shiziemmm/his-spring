package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.SsOperationAnaesthesia;
import cn.gson.hisspring.model.pojos.SsOperationProject;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AnaeMapper extends BaseMapper<SsOperationAnaesthesia> {
    //查询手术项目可选麻醉
    @Select("SELECT a.anaesthesia_id,operation_anaesthesia,b.project_pay FROM ss_change_anaesthesia a \n" +
            "inner join ss_operation_project b on a.project_id =b.project_id\n" +
            "inner join department_ks k on b.ks_id=k.ks_id\n" +
            "inner join ss_operation_anaesthesia c on a.anaesthesia_id=c.anaesthesia_id\n" +
            "where b.project_id=#{projectId}")
    List<SsOperationAnaesthesia> Ana(Integer projectId);

    //查询所有麻醉项目
    @Select("SELECT * FROM ss_operation_anaesthesia")
    List<SsOperationAnaesthesia> allAnaesthesia();
}
