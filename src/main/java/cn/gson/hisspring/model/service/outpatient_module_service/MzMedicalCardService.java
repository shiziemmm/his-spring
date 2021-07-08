package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalCardMapper;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * 门诊-诊疗卡Service
 */

@Service
public class MzMedicalCardService {
    @Autowired
    MzMedicalCardMapper meCardMapper;



//        public static void main(String[] args) {
//            System.out.println(getNum("258852",5));
//        }
    //生成随机卡号
    public Long inserCard(){
        List<MzMedicalCard> mzMedicalCards = meCardMapper.selectList(null);
        if (mzMedicalCards.isEmpty()){//如果数据库没有字段那就自己生成
            System.out.println(Long.parseLong(getNum("258852", 6)));
            return Long.parseLong(getNum("258852", 6));
        }else{
            System.out.println(addMzMedicalCard()+1);
            return addMzMedicalCard()+1;//有就号码加1
        }
    }
    //数据库最大值
    public Long addMzMedicalCard(){
        QueryWrapper<MzMedicalCard> wp = new QueryWrapper<>();
        wp.orderByDesc("mc_card").last("limit 1");
        MzMedicalCard mz = meCardMapper.selectOne(wp);
        //System.out.println("最大编号"+mz.getMcNumberCard());
        return  mz.getMcCard();
    }
    //假设数据库里有个20100505005的编号
    public String getNum(String firstPart, int len) {
        //调用数据库获得20100505005这个编号
        String oldNum = "258852"+"000000";
        int num = Integer.parseInt(oldNum.replace(firstPart,""));
        String numStr = ++num +"";
        int length = numStr.length();
        for (int i = length; i < len; i++) {
            numStr = "0"+numStr;
        }
        return firstPart + numStr;
    }

    public IPage<MzMedicalCard> selectCardCreateTime(Integer index, Integer pageSize) {
        System.out.println("按创建时间排序。。。。。。。。。。。。。。");
        QueryWrapper<MzMedicalCard> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        long count=meCardMapper.selectCount(wrapper);
        IPage<MzMedicalCard> page = new Page<>(index, pageSize, count);
        return  meCardMapper.selectPage(page, wrapper);
    }
}
