package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.TjCodeMan;
import cn.gson.hisspring.model.pojos.TjCodeProject;
import cn.gson.hisspring.model.pojos.ZyPatientBase;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 住院登记mapper层
 */
@Repository
@Mapper
public interface PatientBaseMapper extends BaseMapper<ZyPatientBase> {

    List<ZyPatientBase> selectPatientNoBed(String is);

    List<ZyPatientBase> selectPatientAndPay();

    List<ZyPatientBase> selectPatientBySId(@Param("sId") Long sId, @Param("ksId") Long ksId,@Param("text") String text);

    List<ZyPatientBase> doctorEnjoinExecute(@Param("sId") Long sId, @Param("ksId") Long ksId,@Param("text") String text);

    int updatePatientBasePrice(@Param("price") double price, @Param("ptNo") Long ptNo);

    int insertPatientCheckout(@Param("checkList")List<TjCodeProject> list, @Param("manId") Long manId);
}
