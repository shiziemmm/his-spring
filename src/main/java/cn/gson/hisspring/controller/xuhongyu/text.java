package cn.gson.hisspring.controller.xuhongyu;

import cn.gson.hisspring.model.mapper.xhy.zyBedMapper;
import cn.gson.hisspring.model.pojos.ZyBed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class text {

    @Autowired
    zyBedMapper mapper;

    @RequestMapping("text")
    public List<ZyBed> shizi(){
        return mapper.selectList(null);
//        return "";
    }
}
