package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.*;
import cn.gson.hisspring.model.pojos.pojos_vo.ReCordAllVO;
import cn.gson.hisspring.model.pojos.pojos_vo.RecordVo;
import cn.gson.hisspring.model.service.outpatient_module_service.MzMedicalRecordService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 就诊记录表
 */
@CrossOrigin
@RestController
public class MzMedicalRecordController {
    @Autowired
    MzMedicalRecordService recordService;

    /**
     * 删除对应的中间表数据
     *
     * @param str
     * @return
     */
    @RequestMapping("deleteRe")
    public String deleteRe(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String index = map.get("index").toString();
        String i = map.get("number").toString();
        try {
            recordService.delectRecord(Long.parseLong(index), Long.parseLong(i));
            return "ok";
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "fali";
        }
    }

    /**
     * 问诊界面--查询就诊记录表
     *
     * @param str
     * @return
     */
    @RequestMapping("selectRA")
    public List<ReCordAllVO> selectRA(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String index = map.get("index").toString();
        String texts = map.get("texts").toString().replace(" ", "");
        ;
        return recordService.selectAllRecord(index, texts);
    }

    @RequestMapping("selectRAs1")
    public long selectRA1(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String index = map.get("index").toString();
        String texts = map.get("texts").toString().replace(" ", "");
        ;
        return recordService.selectAllRecord(index, texts).size();
    }

    @RequestMapping("selectRAs2")
    public long selectRA2(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String index = map.get("index").toString();
        String texts = map.get("texts").toString().replace(" ", "");
        ;
        return recordService.selectAllRecord(index, texts).size();
    }

    /**
     * 添加所有就诊信息
     *
     * @param recordVo
     * @return
     */
    @RequestMapping("addRecord")
    public String addRecord(@RequestBody RecordVo recordVo) {
        try {
            System.err.println("就诊记录" + recordVo.getMedicalRecordObject());
            System.err.println("处方" + recordVo.getRecipeObject());
            System.err.println("西药集合" + recordVo.getRecipeObject().getXpList());
            System.err.println("中药集合" + recordVo.getRecipeObject().getZpList());
            System.err.println("手术" + recordVo.getSurgeryStampObject());
            System.err.println("手术集合" + recordVo.getCenterSurgeryList());
            System.err.println("检验" + recordVo.getTjCodeManObject());
            System.err.println("检验集合" + recordVo.getTjManResultList());
            System.err.println("病历" + recordVo.getHistoryObject());
            recordService.addRecipes(recordVo);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     * 缴费查询
     *
     * @param str
     * @return
     */
    @RequestMapping("selectAllRecords")
    public ReCordAllVO selectMedicalRecords(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String texts = map.get("texts").toString().replaceAll(" ", "");
        return recordService.selectMedicalRecord(texts);
    }

    /**
     * 缴费页面进行缴费--打印结果集，修改状态
     *
     * @return
     */
    @RequestMapping("forPrinting")
    public String forPrinting(@RequestBody String str) {
        try {
            Map map = JSON.parseObject(str, Map.class);
            RecordVo recordVo = JSON.parseObject(map.get("recordVo").toString(), RecordVo.class);
            Long sId = Long.parseLong(map.get("sId").toString());
            Long index = Long.parseLong(map.get("index").toString());
            Double price = Double.parseDouble(map.get("price").toString());
            System.err.println("判断" + recordVo);
            if (index == 1) {
//                其他缴费
                recordService.updateStateRecipe(recordVo, sId, 1L);
            } else {
                //卡缴费
                Boolean aBoolean = recordService.setCardPrice(recordVo, sId, 2L, price);
                if (aBoolean) {
                    return "ok";
                } else {
                    return "no";
                }
            }
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fial";
        }
    }


    /**
     * 查询所有的就诊完成记录（已经完成缴费记录的）
     *
     * @return
     */
    @RequestMapping("sCardPawd")
    public MzMedicalCard setCardPrice(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);

        String card = map.get("card").toString();
        return recordService.setCardPrice(card);
    }

    /**
     * 查询所有的就诊完成记录（已经完成缴费记录的）
     *
     * @param str
     * @return
     */
    @RequestMapping("selectRecordsAll")
    public List<ReCordAllVO> selectRecordsAll(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String text = map.get("text").toString().replace(" ", "");
        ;
        ;
        return recordService.selectRecordsAll(text);
    }


    /**
     * 查询所有的就诊完成记录（已经纠正完成的）
     *
     * @param str
     * @return
     */
    @RequestMapping("allRecordsSick")
    public List<ReCordAllVO> allRecordsSick(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String text = map.get("text").toString().replace(" ", "");
        return recordService.allRecordSick(text);
    }

    /**
     * 门诊查询手术等级
     */
    @RequestMapping("ssType")
    public List<Object> selectAllSsObjectType() {
        return recordService.selectAllSsObjectType();
    }

    /**
     * 门诊查询手术
     *
     * @return
     */
    @RequestMapping("mzAllDescSpro")
    public List<SsOperationProject> mzAllDescSpro(@RequestBody String str) {
        Map map = JSON.parseObject(str, Map.class);
        String projectName = map.get("projectName").toString().replace(" ", "");
        String projectType = map.get("projectType").toString();
        return recordService.mzSelectAllSsObject(projectName, projectType);
    }

}
