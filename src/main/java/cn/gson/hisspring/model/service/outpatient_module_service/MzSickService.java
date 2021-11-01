package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalCardMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzSickMapper;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.MzSick;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 门诊-病人资料service
 */

@Service
@Transactional
public class MzSickService {
    @Autowired
    MzSickMapper mzSickMapper;//病人信息
    @Autowired
    MzMedicalCardMapper mzMedicalCardMapper;//诊疗卡


    /**
     * 身份证校验
     *
     * @param idCard
     * @return
     */
    public Boolean idCard(String idCard) {
        MzMedicalCard mzSick = mzMedicalCardMapper.selectAllMzMedicalCard2(idCard);
        if (mzSick != null) {
            return true;
        } else {
            return false;
        }
    }


    //新增病人信息
    public void addMzSick(MzSick mzSick) {
        if (mzSick != null) {
            //拿传过来的值去查询一遍看是否存在存在就修改。不存在就新增
            MzSick mzSick1 = mzSickMapper.selectById(mzSick.getSickIdCard());
            if (isNull(mzSick1)) {//如果不存在就新增
                //新增病人时间
                mzSick.setSickTime(new Timestamp(System.currentTimeMillis()));//赋值当前系统时间
                mzSickMapper.insert(mzSick);
                //新增卡号
                MzMedicalCard card = new MzMedicalCard();
                card.setMcCard(mzSick.getMcNumberCard());
                System.out.println("卡号" + mzSick.getMcNumberCard());
                card.setMcIdCard(mzSick.getSickIdCard());
                card.setMcPawd(getIdCard(mzSick.getSickIdCard()));
                card.setMcBalance(0);
                card.setSickNumber(mzSick.getSickNumber());
                card.setMcSate(0);
                mzMedicalCardMapper.insert(card);
            } else {
//                mzSickMapper.updateById(mzSick);
                System.out.println("修改");
            }
        }
    }


    //判断非空
    public boolean isNull(Object obj) {
        if (obj == null || "".equals(obj.toString())) {
            return true;
        }
        return false;
    }

    //截取身份证后六位有X就跳过
    public String getIdCard(String id) {
        Pattern p = Pattern.compile("[0-9]+[X|x]{1}");
        Matcher m = p.matcher(id);
        boolean b = m.matches();
        if (b) {
            id = id.substring(id.length() - 7, id.length() - 1);
        } else {
            id = id.substring(id.length() - 6);
        }
        return id;
    }
}
