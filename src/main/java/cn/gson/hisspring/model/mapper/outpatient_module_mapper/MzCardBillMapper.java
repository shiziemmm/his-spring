package cn.gson.hisspring.model.mapper.outpatient_module_mapper;

import cn.gson.hisspring.model.pojos.MzCardBill;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *  门诊账单表 mapper
 */
@Mapper
public interface MzCardBillMapper extends BaseMapper<MzCardBill> {
    List<MzCardBill> cardBillSe(long card);
}
