package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YfDrugcategory;
import cn.gson.hisspring.model.pojos.YfDruginformation;
import cn.gson.hisspring.model.pojos.YkDrugspecifcations;
import cn.gson.hisspring.model.pojos.YkSupplier;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DrugInformationMapper extends BaseMapper<YfDruginformation> {
    //查询药品信息
    List <YfDruginformation> queryById();
    //新增药品信息
    void addDrug(YfDruginformation yfDruginformation);
    //修改药品信息
    void updaDrug(YfDruginformation yfDruginformation);
    //查询规格
    List<YkDrugspecifcations> allspec();
    //查询供应商
    List<YkSupplier> allsupp();
    //查询类别
    List<YfDrugcategory> alldrca();
}
