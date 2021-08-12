package cn.gson.hisspring.model.mapper.checkout_module_mapper;

import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.SsOperationAnaesthesia;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 门诊-诊疗卡体检用mapper
 */
@Mapper
public interface MzMedicalCardMapper1 extends BaseMapper<MzMedicalCard> {
//    查询诊疗卡
    @Select("select * from  mz_medical_card where mc_Id_Card=#{mcIdCard}")
    List<MzMedicalCard> allmzmidCard(String mcIdCard);
    //修改诊疗卡金额
    @Update("update  mz_medical_card set mc_balance=#{mcBalance} where mc_Id_Card=#{mcIdCard}")
    public void updMoney(Integer mcBalance,String mcIdCard);
}
