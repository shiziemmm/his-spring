package cn.gson.hisspring.controller.inhospital_module_controller;


import cn.gson.hisspring.model.pojos.Staff;
import cn.gson.hisspring.model.pojos.ZyPay;
import cn.gson.hisspring.model.pojos.pojos_vo.SelectExecuteVo;
import cn.gson.hisspring.model.service.inhospital_module_service.PayService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * 住院缴费controller
 */
@RestController
@CrossOrigin
public class PayController {

    @Autowired
    PayService ps;

    /**
     * 添加病人缴费记录
     * @param str
     * @return
     */
    @RequestMapping("addPay")
    public boolean addPay(@RequestBody String str){
        System.out.println(str);
        ZyPay pay = JSON.parseObject(str, ZyPay.class);
        System.out.println(pay);
        return ps.addPay(pay);
    }

    /**
     * 根据住院号查询病人缴费记录
     */
    @RequestMapping("select-pay-byPtId")
    public List<ZyPay> selectPayByPtId(@RequestBody String str){
        System.err.println(str);
        Map map = JSON.parseObject(str, Map.class);

        Long ptNo = JSON.parseObject(map.get("ptNo").toString(),Long.class);//住院编号
        SelectExecuteVo executeVo = JSON.parseObject(map.get("payWhere").toString(),SelectExecuteVo.class);//条件
       return ps.selectPayByPtNo(ptNo,executeVo);
    }


    /**
     * 根据住院号查询操作员工
     */
    @RequestMapping("selectBy-ptno-staff")
    public List<Staff> selectByPtNoStaff(Long ptNo){
        return ps.selectByPtNoStaff(ptNo);
    }


    /**
     * 根据住院号查询病人缴费余额
     */
    @RequestMapping("select-PayBy-PtNoPrice")
    public Double selectPayByPtNoPrice(Long ptNo){
        return ps.selectPayByPtNoPrice(ptNo);
    }
}
