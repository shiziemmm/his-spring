package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.ResultManVo;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * 住院登记mapper层
 */
@Repository
@Mapper
public interface PatientBaseMapper extends BaseMapper<ZyPatientBase> {

    List<ZyPatientBase> selectPatientNoBed(@Param("is") String is, @Param("searchLike") String searchLike, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

    List<ZyPatientBase> selectPatientAndPay(SelectExecuteVo selectExecuteVo);

    List<ZyPatientBase> selectPatientNoOutCY(SelectExecuteVo selectExecuteVo);

    List<ZyPatientBase> selectPatientBySId(@Param("sId") Long sId, @Param("ksId") Long ksId, @Param("text") String text);

    List<ZyPatientBase> doctorEnjoinExecute(@Param("sId") Long sId, @Param("ksId") Long ksId, @Param("text") String text);

    int updatePatientBasePrice(@Param("price") double price, @Param("ptNo") Long ptNo);

    int updatePatientBasePriceAndMoney(@Param("price") double price, @Param("ptNo") Long ptNo);

    int insertPatientCheckout(@Param("checkList") List<TjCodeProject> list, @Param("manId") Long manId, @Param("sId") Long sId);

    List<ResultManVo> selectResultByManId(SelectExecuteVo selectExecuteVo);

    List<Staff> selectResultByManIdStaff(Long manId);

    List<Scheduling> selectDateByKsId(Long ksId);
}
