package cn.gson.hisspring.controller.outpatient_module_controller;

import cn.gson.hisspring.model.pojos.MzMedicalRecord;
import cn.gson.hisspring.model.pojos.MzPayment;
import cn.gson.hisspring.model.pojos.SsOperationProject;
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

    @RequestMapping("selectRA")
    public List<ReCordAllVO> selectRA(@RequestBody String str){
        Map map = JSON.parseObject(str,Map.class);
        String index = map.get("index").toString();
        String text = map.get("texts").toString().replace(" ", "");;
        return recordService.selectAllRecord(index,text);
    }

    /**
     * 添加所有就诊信息
     * @param recordVo
     * @return
     */
    @RequestMapping("addRecord")
    public String addRecord(@RequestBody RecordVo recordVo){
        try {
            System.err.println("就诊记录"+recordVo.getMedicalRecordObject());
            System.err.println("处方"+recordVo.getRecipeObject());
            System.err.println("西药集合"+recordVo.getRecipeObject().getXpList());
            System.err.println("中药集合"+recordVo.getRecipeObject().getZpList());
            System.err.println("手术"+recordVo.getSurgeryStampObject());
            System.err.println("手术集合"+recordVo.getCenterSurgeryList());
            System.err.println("检验"+recordVo.getTjCodeManObject());
            System.err.println("检验集合"+recordVo.getTjManResultList());
            System.err.println("病历"+recordVo.getHistoryObject());
            recordService.addRecipe(recordVo);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    /**
     *  查询就诊信息（已接诊和已经完成接诊的人员）
     * @param str
     * @return
     */
    @RequestMapping("selectAllRecord")
    public List<MzMedicalRecord> selectMedicalRecord( @RequestBody String str){
        Map map = JSON.parseObject(str, Map.class);
        String index = map.get("index").toString();
        String texts = map.get("texts").toString().replace(" ", "");
        System.err.println(index);
        System.err.println(texts);
        return recordService.selectMedicalRecord(index,texts);
    }

    /**
     * 缴费查询
     * @param str
     * @return
     */
    @RequestMapping("selectAllRecords")
    public MzMedicalRecord selectMedicalRecords(@RequestBody String str){
        Map map = JSON.parseObject(str, Map.class);
        String texts = map.get("texts").toString().replace(" ", "");
        return recordService.selectMedicalRecord(texts);
    }

    /**
     * 打印结果集，修改状态
     * @param str
     * @return
     */
    @RequestMapping("forPrinting")
    public String forPrinting(@RequestBody String str){
        try {
            Map map = JSON.parseObject(str, Map.class);
            String index = map.get("index").toString();
            String xmName = map.get("xmName").toString().replace(" ", "");;;
            MzPayment payment = JSON.parseObject(map.get("payment").toString(),MzPayment.class);
            System.err.println(index);
            recordService.updateStateRecipe(index,xmName,payment);
            return "ok";
        } catch (Exception e) {
            e.printStackTrace();
            return "fial";
        }
    }

    /**
     * 查询所有的就诊完成记录（已经完成缴费记录的）
     * @param str
     * @return
     */
    @RequestMapping("selectRecordsAll")
    public List<MzMedicalRecord> selectRecordsAll(@RequestBody String str){
        Map map = JSON.parseObject(str,Map.class);
        String text = map.get("text").toString().replace(" ", "");;;
        return recordService.selectRecordsAll(text);
    }


    /**
     * 查询所有的就诊完成记录（已经纠正完成的）
     * @param str
     * @return
     */
    @RequestMapping("allRecordsSick")
    public List<MzMedicalRecord> allRecordsSick(@RequestBody String str){
        Map map = JSON.parseObject(str,Map.class);
        String text = map.get("text").toString().replace(" ", "");
        return recordService.allRecordSick(text);
    }

    /**
     * 门诊查询手术等级
     */
    @RequestMapping("ssType")
    public List<Object>  selectAllSsObjectType(){
        return recordService.selectAllSsObjectType();
    }
    /**
     * 门诊查询手术
     * @return
     */
    @RequestMapping("mzAllDescSpro")
    public List<SsOperationProject> mzAllDescSpro(@RequestBody String  str){
        Map map = JSON.parseObject(str,Map.class);
        String projectName = map.get("projectName").toString().replace(" ", "");
        String projectType = map.get("projectType").toString();
        return recordService.mzSelectAllSsObject(projectName,projectType);
    }

}
