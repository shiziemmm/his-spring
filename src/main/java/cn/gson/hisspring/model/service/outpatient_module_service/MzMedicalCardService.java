package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalCardMapper;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import cn.gson.hisspring.model.pojos.MzSick;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
/**
 * 门诊-诊疗卡Service
 */

@Service
public class MzMedicalCardService {
    @Autowired
    MzMedicalCardMapper meCardMapper;

    @Autowired
    MzSickService mzSick;
    //分页排序查询数据库病人信息
    public IPage<MzMedicalCard> selectCardCreateTime(Integer index, Integer pageSize) {
        System.out.println("按创建时间排序。。。。。。。。。。。。。。");
        QueryWrapper<MzMedicalCard> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("create_time");
        long count=meCardMapper.selectCount(wrapper);
        IPage<MzMedicalCard> page = new Page<>(index, pageSize, count);
        return  meCardMapper.selectPage(page, wrapper);
    }
    //查询所有加排序
    public List<MzMedicalCard> selectAllCards(String mzSickTest){
        System.out.println("按创建时间排序。。。。。。。。。。。。。。");
        List<MzMedicalCard> mzMedicalCards = meCardMapper.selectAllMzMedicalCard(mzSickTest);
        return mzMedicalCards;
    }
    //重置密码卡密码和修改卡密码
    public void pawdReset(String mcNumber,String pawd1){
        MzMedicalCard card = meCardMapper.selectById(mcNumber);
        if (card!=null){
            if(pawd1!=null){//修改密码
                card.setMcPawd(pawd1);
                meCardMapper.updateById(card);
            }else{//重置密码
                card.setMcPawd(mzSick.getIdCard(card.getMcIdCard()));
                meCardMapper.updateById(card);
            }
        }
    }
    //挂失卡号，--挂失补办&挂失退额
    public void cardState(String mcNumber,String mcCard){
        MzMedicalCard card = meCardMapper.selectById(mcNumber);
        if (card!=null){
            if(mcCard!=null){ // 卡号！=null就进入挂失补办
                MzMedicalCard cards = new MzMedicalCard();//新政卡
                cards.setMcCard(Long.parseLong(mcCard));
                cards.setMcIdCard(card.getMcIdCard());
                cards.setMcBalance(card.getMcBalance());
                cards.setMcPawd(card.getMcPawd());
                cards.setMcSate(0);
                cards.setSickNumber(card.getSickNumber());
                meCardMapper.insert(cards);
                card.setMcSate(1L);//修改卡状态
                card.setMcBalance(0);//清空余额转到新卡去
                meCardMapper.updateById(card);
            }else{//进入挂失退额
                card.setMcSate(1L);//修改卡状态
                card.setMcBalance(0);//清空卡余额
                meCardMapper.updateById(card);
            }
        }
    }







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
}
