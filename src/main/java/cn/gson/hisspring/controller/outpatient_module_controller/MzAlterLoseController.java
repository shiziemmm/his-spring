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
public class  MzAlterLoseController {
    @Autowired
    MzAlterLoseService loseService;

    //查询所有诊疗卡操作记录like不等于null就模糊查询
    @GetMapping("likeAlterLose")
    public List<MzAlterLose> likeAlterLose(String like){
        return loseService.allLikeAlterLose(like);
    }


}
