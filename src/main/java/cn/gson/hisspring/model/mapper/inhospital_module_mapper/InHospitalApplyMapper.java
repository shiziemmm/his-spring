package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.ZyInhospitalApply;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * 住院申请mapper层
 */
@Mapper
@Repository
public interface InHospitalApplyMapper extends BaseMapper<ZyInhospitalApply> {

    List<Staff> selectPatientStaffAll();

    List<ZyInhospitalApply> selectHspApplyByInIs(@Param("inIs") String inIs, @Param("doctorType") Long doctorType, @Param("searchLike") String searchLike, @Param("startDate") Date startDate,@Param("endDate") Date endDate);
}
