package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.YkStorageDetail;
import cn.gson.hisspring.model.service.pharmacy_module_service.YkStorageDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class YkStorageDetailController {
    @Autowired
    YkStorageDetailService deser;

    //查询出入库记录详表
    @RequestMapping("allstoragedetail")
    public List<YkStorageDetail> allstoragedetail(Float ykStorageId) {
        return deser.allstoragedetail(ykStorageId);
    }
}
