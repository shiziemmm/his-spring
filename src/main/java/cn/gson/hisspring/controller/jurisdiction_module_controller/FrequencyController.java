package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.Frequency;
import cn.gson.hisspring.model.service.jurisdiction_module_service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class FrequencyController {
    @Autowired
    FrequencyService fs;

    @RequestMapping("select-fre")
    public List<Frequency> selectAll(){
        return fs.selectAll();
    }

    @RequestMapping("add-fre")
    public int addFre(Frequency frequency){
        int i=fs.addFre(frequency);
        if(i>0){
            return 1;
        }else{
            return 0;
        }
    }
}
