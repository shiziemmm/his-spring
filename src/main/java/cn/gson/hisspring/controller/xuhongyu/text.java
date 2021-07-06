package cn.gson.hisspring.controller.xuhongyu;

import cn.gson.hisspring.model.mapper.xhy.textMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class text {

//    @Autowired
//    textMapper mapper;

    @RequestMapping("text")
    public String shizi(){
//        return mapper.selectString();
        return "";
    }
}
