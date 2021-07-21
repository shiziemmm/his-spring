package cn.gson.hisspring.model.service.outpatient_module_service;

import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzAlterLoseMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMcRechargeMapper;
import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzMedicalCardMapper;
import cn.gson.hisspring.model.pojos.MzAlterLose;
import cn.gson.hisspring.model.pojos.MzMcRecharge;
import cn.gson.hisspring.model.pojos.MzMedicalCard;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
/**
 * 门诊-诊疗卡Service
 */

@Service
@Transactional
public class MzMedicalCardService {
    @Autowired
    MzMedicalCardMapper meCardMapper;//诊疗卡mapper

    @Autowired
    MzSickService mzSick;//病人信息service

    @Autowired
    MzAlterLoseMapper mzAlterLose;//挂失修改记录mapper

    @Autowired
    MzMcRechargeService rechargeService;//recharge业务层
    @Autowired
    MzMcRechargeMapper rechargeMapper;//recharge层级mapper

    //查询单卡
    public MzMedicalCard selectById(String mcCard){
        return meCardMapper.selectByIdObject(mcCard);
    }

    //分页排序查询数据库病人信息--暂时没用到
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
    public void pawdReset(String mcNumber,String pawd1,String userId){
        MzMedicalCard card = meCardMapper.selectById(mcNumber);
        if (card!=null){
            if(pawd1!=null){//修改密码

                card.setMcPawd(pawd1);
                meCardMapper.updateById(card);
                MzAlterLose lose = new MzAlterLose();
                lose.setAlCard(card.getMcCard());
                lose.setAlPrice(null);
                lose.setAlCause("密码修改");
                lose.setSId(Long.parseLong(userId));
                lose.setSickNumber(card.getSickNumber());
                lose.setMcNumber(null);

                this.mzAlterLose.insert(lose);

            }else{//重置密码
                card.setMcPawd(mzSick.getIdCard(card.getMcIdCard()));
                meCardMapper.updateById(card);
            }
        }
    }
    //挂失卡号，--挂失补办&挂失退额
    public void cardState(String mcNumber,String mcCard,String userId){
        MzMedicalCard card = meCardMapper.selectById(mcNumber);
        if (card!=null){
            if(mcCard!=null){ // 卡号！=null就进入挂失补办

                MzMedicalCard cards = new MzMedicalCard();//新增卡
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

                MzAlterLose lose = new MzAlterLose();//新增到记录表去
                lose.setAlCard(card.getMcCard());//旧卡卡号
                lose.setAlPrice(cards.getMcBalance());//转到新卡的金额
                lose.setAlCause("挂失补办");
                lose.setSId(Long.parseLong(userId));//操作人id
                lose.setSickNumber(cards.getSickNumber());//病人id
                lose.setMcNumber(cards.getMcNumber());//新增新卡的id
                this.mzAlterLose.insert(lose);

            }else{//进入挂失退额
                card.setMcSate(1L);//修改卡状态
                card.setMcBalance(0);//清空卡余额
                meCardMapper.updateById(card);
                //新增到记录表去
                MzAlterLose lose = new MzAlterLose();
                lose.setAlCard(card.getMcCard());//退额卡号
                lose.setAlPrice(card.getMcBalance());//退额金额
                lose.setAlCause("挂失退额");
                lose.setSId(Long.parseLong(userId));//操作人id
                lose.setSickNumber(card.getSickNumber());//病人id
                lose.setMcNumber(null);//新增新卡的id
                this.mzAlterLose.insert(lose);
            }
        }
    }

    //诊疗卡的充值记录表
    public void setCardPrice(String mcNumber, String upPrice,String payment, String userId, Integer index){
        MzMedicalCard card = meCardMapper.selectById(mcNumber);
        if (card!=null){
            if(index == 1  ){ // 充值卡余额 1就充值2就退钱
                //诊疗卡余额修改
                card.setMcBalance(card.getMcBalance()+Double.parseDouble(upPrice));//卡余额 +
                meCardMapper.updateById(card);//修改余额--充值
                //新增到记录表去
                MzMcRecharge mzMcRecharge = new MzMcRecharge();
                mzMcRecharge.setSId(Long.parseLong(userId));
                mzMcRecharge.setMcNumber(card.getMcNumber());
                mzMcRecharge.setMcrcPayment(payment);
                mzMcRecharge.setMcrcState("诊卡充值");
                mzMcRecharge.setMcrcPrice(Double.parseDouble(upPrice));
                rechargeMapper.insert(mzMcRecharge);
            }else{
                System.err.println("111111111111111111111111111111111111111111");
                //诊疗卡余额修改
                card.setMcBalance(card.getMcBalance()-Double.parseDouble(upPrice));//卡余额 -
                meCardMapper.updateById(card);//修改余额--退款
                //新增到记录表去
                MzMcRecharge mzMcRecharge = new MzMcRecharge();
                mzMcRecharge.setSId(Long.parseLong(userId));
                mzMcRecharge.setMcNumber(card.getMcNumber());
                mzMcRecharge.setMcrcPayment(null);
                mzMcRecharge.setMcrcState("诊卡退款");
                mzMcRecharge.setMcrcPrice(Double.parseDouble(upPrice));
                rechargeMapper.insert(mzMcRecharge);
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
