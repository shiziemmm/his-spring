package cn.gson.hisspring.controller.inhospital_module_controller;

import cn.gson.hisspring.model.pojos.MzCaseHistory;
import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import cn.gson.hisspring.model.service.inhospital_module_service.CaseHistoryService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public boolean addCaseHistory(@RequestBody MzCaseHistory mzCaseHistory) {
        System.err.println(mzCaseHistory);
        return chs.addCaseHistory(mzCaseHistory);
    }

    /**
     * 根据病人住院号查询病例
     *
     * @return
     */
    @RequestMapping("select-byPtNo-case")
    public List<MzCaseHistory> selectByPtNoCase(@RequestBody String str) {
        System.err.println(str);
        SelectExecuteVo selectExecuteVo = JSON.parseObject(str, SelectExecuteVo.class);
        return chs.selectBySickNumberPtNoCase(selectExecuteVo);
    }


    /**
     * 根据病人信息编号查询出开立病历所有意思信息
     */
    @RequestMapping("select-by-sickNumber-staff")
    public List<Staff> selectCaseStaff(Long sickNumber) {
        return chs.selectCaseStaff(sickNumber);
    }

}
