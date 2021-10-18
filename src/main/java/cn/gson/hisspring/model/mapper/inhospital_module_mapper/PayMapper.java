package cn.gson.hisspring.model.mapper.inhospital_module_mapper;

import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.ZyPay;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;

import java.util.Date;
import java.util.List;

/**
 * 住院缴费mapper
 */
@Repository
public interface PayMapper extends BaseMapper<ZyPay> {

    List<ZyPay> selectPayByPtNo(@Param("ptNo") Long ptNo, @Param("startDate") Date startDate, @Param("endDate") Date endDate, @Param("sIdArr") List<Long> sId);

    List<Staff> selectByPtNoStaff(Long ptNo);

    Double selectPayByPtNoPrice(Long ptNo);
}
