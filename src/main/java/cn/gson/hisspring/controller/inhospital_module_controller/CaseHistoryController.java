package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.MzCaseHistory;
import cn.gson.hisspring.model.service.inhospital_module_service.CaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 住院病人病例Controller
 */
@RestController
@CrossOrigin
public class CaseHistoryController {
    @Autowired
    CaseHistoryService chs;//住院病人病例Service

    /**
     * 添加病人病例方法
     */
    @RequestMapping("zy-add-caseHistory")
    public boolean addCaseHistory(@RequestBody MzCaseHistory mzCaseHistory){
        System.err.println(mzCaseHistory);
        return chs.addCaseHistory(mzCaseHistory);
    }

}
