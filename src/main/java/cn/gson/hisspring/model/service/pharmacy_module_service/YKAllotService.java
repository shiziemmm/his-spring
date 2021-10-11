package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YKAllotMapper;
import cn.gson.hisspring.model.pojos.YfDruginventory;
import cn.gson.hisspring.model.pojos.YkAllot;
import cn.gson.hisspring.model.pojos.YkAllotdetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YKAllotService {

    @Autowired
    YKAllotMapper ykAllotMapper;

    //查询调拨申请
    public List<YkAllot> allykallot(){
        return ykAllotMapper.allykallot();
    }

    //查询调拨详表
    public List<YkAllotdetail> alldetail(){
        return ykAllotMapper.alldetail();
    }

    //新增调拨记录
    public void adddykallot(YkAllot ykAllot){

        YkAllot allot = new YkAllot();


        allot.setYkAllotId(ykAllot.getYkAllotId());
        allot.setYkAllotCause(ykAllot.getYkAllotCause());
        allot.setYkAllotTime(ykAllot.getYkAllotTime());
        allot.setsId(ykAllot.getsId());
        allot.setYkAllotName(ykAllot.getYkAllotName());

        ykAllotMapper.adddykallot(ykAllot);
        System.out.println("121212");


        for (YfDruginventory y : ykAllot.getYfDruginventories()) {


           YkAllotdetail a=new YkAllotdetail();
            a.setYkAllotId(allot.getYkAllotId());
           a.setYkDrvenDrugName(y.getYfDrvenName());
           a.setYkAllotdetailCount(y.getYfNumbers());
           a.setYkAllotdetailIs(1);

           ykAllotMapper.addykallotdetail(a);

        }


//        for (YkAllotdetail y : ykAllot.getYkAllotdetail()) {
//
//            YkAllotdetail a=new YkAllotdetail();
//            System.out.println(ykAllot.getYkAllotId()+"-----121212121212121");
//            y.setYkAllotId(ykAllot.getYkAllotId());
//            System.out.println(ykAllot.getYkAllotId()+"---------------------");
//            y.setYkAllotdetailIs(1);
//            y.setYkAllotdetailCount(a.getYkAllotdetailCount());
//            ykAllotMapper.addykallotdetail(y);
//
//        }
    }
   /* //新增调拨详表
    public void addykallotdetail(YkAllotdetail ykAllotdetail){
        ykAllotMapper.addykallotdetail(ykAllotdetail);
    }*/
}
