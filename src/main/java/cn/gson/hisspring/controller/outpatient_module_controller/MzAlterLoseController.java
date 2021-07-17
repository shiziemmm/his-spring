package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzAlterLose;
import cn.gson.hisspring.model.service.outpatient_module_service.MzAlterLoseService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 门诊诊疗卡操作记录，补卡修改记录-Controller
 */

@CrossOrigin
@RestController
public class MzAlterLoseController {
    @Autowired
    MzAlterLoseService loseService;

    @GetMapping("likeAlterLose")
    public List<MzAlterLose> likeAlterLose(String like){
        System.err.println(like+"ssssssssssssssssssssssssss");
        return loseService.allLikeAlterLose(like);
    }


}
