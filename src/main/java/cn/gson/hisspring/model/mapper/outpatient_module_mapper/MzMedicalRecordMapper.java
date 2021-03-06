package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzMedicalRecord;
import cn.gson.hisspring.model.pojos.SsOperationProject;
import cn.gson.hisspring.model.pojos.pojos_vo.ReCordAllVO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 就诊记录表
 */

@Mapper
public interface MzMedicalRecordMapper extends BaseMapper<MzMedicalRecord> {
    //查询未缴费的记录。开始缴费查询
    ReCordAllVO selectAllReCordObject2(String texts);
    //查询就诊记录
    List<MzMedicalRecord>chaxunnums();
    /**
     * 查询所有的缴费完成记录
     */
    List<ReCordAllVO> selectAllReCordObject3(String texts);
    ///病人信息查询 已经就诊完成了的人
//    List<MzMedicalRecord> allRecordSick(String text);
    //查询手术等级
    @Select("select DISTINCT project_type from ss_operation_project")
    List<Object> selectAllSsObjectType();
    //查询手术（一级或。。）
    List<SsOperationProject> mzSelectAllSsObject(String projectName,String projectType);
}
