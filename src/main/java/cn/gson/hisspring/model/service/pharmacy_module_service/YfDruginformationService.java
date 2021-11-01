package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.DrugInformationMapper;
import cn.gson.hisspring.model.pojos.YfDrugcategory;
import cn.gson.hisspring.model.pojos.YfDruginformation;
import cn.gson.hisspring.model.pojos.YkDrugspecifcations;
import cn.gson.hisspring.model.pojos.YkSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YfDruginformationService {
    @Autowired
    DrugInformationMapper information_mapper;

    /*查询药品信息*/
    public List<YfDruginformation> queryById() {
        return information_mapper.queryById();
    }

    /*新增药品信息*/
    public void addDrug(YfDruginformation yfDruginformation) {
        information_mapper.addDrug(yfDruginformation);
    }

    /*修改药品信息*/
    public void updaDrug(YfDruginformation yfDruginformation) {
        information_mapper.updaDrug(yfDruginformation);
    }

    /*查询规格*/
    public List<YkDrugspecifcations> allspec() {
        return information_mapper.allspec();
    }

    /*查询供应商*/
    public List<YkSupplier> allsupp() {
        return information_mapper.allsupp();
    }

    /*查询类别*/
    public List<YfDrugcategory> alldrca() {
        return information_mapper.alldrca();
    }
}
