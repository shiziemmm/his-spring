package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzPaymentDetailed;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 门诊缴费记录中间表
 */
@Mapper
public interface MzPaymentDetailedMapper extends BaseMapper<MzPaymentDetailed> {

}
