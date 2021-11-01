package cn.gson.hisspring.controller.jurisdiction_module_controller;

import cn.gson.hisspring.model.pojos.Title;
import cn.gson.hisspring.model.service.jurisdiction_module_service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
/**
 * 查询职称
 */
public class TitleController {
    @Autowired
    TitleService titleService;

    //查询所有职称
    @RequestMapping("titel-list")
    public List<Title> selectAll() {
        return titleService.selectList();
    }
}
