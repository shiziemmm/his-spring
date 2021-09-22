package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.YKAllotMapper;
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
    //新增调拨
    public void adddykallot(YkAllot ykAllot){

        YkAllot allot = new YkAllot();
        allot.setYkAllotId(ykAllot.getYkAllotId());
        allot.setYkAllotCause(ykAllot.getYkAllotCause());
        allot.setYkAllotTime(ykAllot.getYkAllotTime());
        allot.setSId(ykAllot.getSId());
        allot.setYkAllotName(ykAllot.getYkAllotName());

        ykAllotMapper.adddykallot(ykAllot);

        for(YkAllotdetail list: allot.getYkAllotdetail()){
            YkAllotdetail allotdetail = new YkAllotdetail();
            allotdetail.setYkAllotdetailId(list.getYkAllotdetailId());
            allotdetail.setYkAllotId(list.getYkAllotId());
            allotdetail.setYkAllotdetailIs(list.getYkAllotdetailIs());
            allotdetail.setYkAllotdetailCount(list.getYkAllotdetailCount());
            allotdetail.setYkDruginventory(list.getYkDruginventory());
            allotdetail.setYkDrvenDrugName(list.getYkDrvenDrugName());

            ykAllotMapper.addykallotdetail(allotdetail);
        }
    }
   /* //新增调拨详表
    public void addykallotdetail(YkAllotdetail ykAllotdetail){
        ykAllotMapper.addykallotdetail(ykAllotdetail);
    }*/
}
