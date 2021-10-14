package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.MzZprescription;
import cn.gson.hisspring.model.service.pharmacy_module_service.MzzyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class MzzyController {
    @Autowired
    MzzyService mzzyser;

    //查询门诊中药需要发的药品
    @RequestMapping("allmzzy")
    public List<MzZprescription> allmzzy(){
        return mzzyser.allmzzy();
    }
}
