package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.Supplier_Mapper;
import cn.gson.hisspring.model.pojos.YkSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *供应商
 */

@Service
public class Supplier_Service {
    @Autowired
    Supplier_Mapper supplier_mapper;

    /*查询供应商*/
    public List<YkSupplier> selectAllSupplier(){
        return supplier_mapper.selectAllSupplier();
    }
    /*新增供应商*/
    public void insertSupplier(YkSupplier ykSupplier){
        supplier_mapper.insertSupplier(ykSupplier);
    }
    /*修改供应商信息*/
    public void updateSupplier(YkSupplier ykSupplier){
        supplier_mapper.updateSupplier(ykSupplier);
    }
}
