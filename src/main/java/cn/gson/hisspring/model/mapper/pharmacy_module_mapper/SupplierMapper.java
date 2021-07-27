package cn.gson.hisspring.model.mapper.pharmacy_module_mapper;

import cn.gson.hisspring.model.pojos.YkSupplier;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 *供应商
 */

@Mapper
public interface SupplierMapper {
    //    查询供应商
    List <YkSupplier> selectAllSupplier();
    //  新增供应商
    void insertSupplier(YkSupplier ykSupplier);
    //修改供应商信息
    void updateSupplier(YkSupplier ykSupplier);
}
