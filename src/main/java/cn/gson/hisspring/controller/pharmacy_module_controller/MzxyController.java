package cn.gson.hisspring.controller.pharmacy_module_controller;

import cn.gson.hisspring.model.pojos.MzXprescription;
import cn.gson.hisspring.model.service.pharmacy_module_service.MzxyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin /*跨域*/
public class MzxyController {
    @Autowired
    MzxyService mzxyser;

    @RequestMapping("allmzxy")
    public List<MzXprescription> allmzxy(Long recipeNumber) {
        return mzxyser.allmzxy(recipeNumber);
    }
}
