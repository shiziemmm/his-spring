package cn.gson.hisspring.model.service.pharmacy_module_service;

import cn.gson.hisspring.model.mapper.pharmacy_module_mapper.*;
import cn.gson.hisspring.model.pojos.*;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@Transactional
public class YKAllotService {

    @Autowired
    YKAllotMapper ykAllotMapper;//药库调拨单mapper

    @Autowired
    YkAllotdetailMapper yam;//药库调拨详单mapper

    @Autowired
    DrugStorageMapper dsm;//药库mapper

    @Autowired
    YKStorageMapper ysgm;//出库mapper

    @Autowired
    YkStorageDetailMapper ysgdm;//出库详单mapper

    @Autowired
    YFDruglnventoryMapper ydtm;//药房mapper

    @Autowired
    DrugInformationMapper difm;//药品信息mapper


    public void  addyf(List<YkAllot> allotList,Long sId){
        //变量
        Long ykStorageId = getOrderIdByTime();//出库编号

        //新增出库记录主表
        YkStorage ysgObj = new YkStorage();
        ysgObj.setYkStorageId(ykStorageId);
        ysgObj.setSId(sId);
        ysgObj.setYkStorageCause("药库调拨至药房");
        ysgObj.setYkStorageOutorenter(2L);//表示出库
        ysgm.insert(ysgObj);//新增出库记录主表
        //先根据调拨编号查询出需要发药的数据
        for (YkAllot ykAllot : allotList) {//循环查询调拨详表

            System.err.println(ykAllot.getYkAllotId());
            QueryWrapper<YkAllotdetail> qwAl = new QueryWrapper<YkAllotdetail>().eq("yk_Allotdetail_Is",1).eq("yk_allot_id",ykAllot.getYkAllotId());
            List<YkAllotdetail> allotdetails = yam.selectList(qwAl);
            System.err.println("调拨详表"+allotdetails);
            for (YkAllotdetail allotdetail : allotdetails) {//循环调拨详单
                Long drugCount = allotdetail.getYkAllotdetailCount();//需要发药的数量
                //根据调拨详单里面的药品编号查询出药库的药品集合
                QueryWrapper<YkDruginventory> DruginventoryQW = new QueryWrapper<YkDruginventory>().eq("drug_id",allotdetail.getYkDrugId())
                        .orderByAsc("YK_drven_mftDate");
                List<YkDruginventory> ykDruginventoryList = dsm.selectList(DruginventoryQW);//查询药库所有一样药品编号的数据
                for (YkDruginventory ykList : ykDruginventoryList) {
                    if (drugCount <= ykList.getYkDrvenCount() && ykList.getYkDrvenCount() >0){//如果进这边说明可以扣除库存
                        //先减药库库存
                        YkDruginventory ykdObj = new YkDruginventory(ykList.getYkDrvenId(),ykList.getYkDrvenCount()-drugCount);
                        dsm.updateById(ykdObj);//修改药库库存

                        //新增出库记录详情表
                        YkStorageDetail ysgdObj = new YkStorageDetail();
                        ysgdObj.setYkStorageId(ykStorageId);
                        ysgdObj.setYkDrvenId(ykList.getYkDrvenId());//药库编号
                        ysgdObj.setYkStorageDetailCount(drugCount);//出库数量
                        ysgdObj.setDrugId(ykList.getDrugId());//药品编号
                        ysgdm.insert(ysgdObj);//新增出库详表记录

                        //先查询药房是否存在这一批次的药品
                        QueryWrapper<YfDruginventory> yfDruginventoryQW = new QueryWrapper<YfDruginventory>()
                                .eq("YF_drven_batch",ykList.getYkDrvenBatch()).eq("drug_id",ykList.getDrugId());
                        List<YfDruginventory> yfDruginventoriesList = ydtm.selectList(yfDruginventoryQW);

                        //根据药品编号查询药品信息
                        YfDruginventory yfDrugObj = new YfDruginventory();
                        YfDruginformation yfDruginformation = difm.selectById(ykList.getDrugId());//药品信息对象
                        if (yfDruginventoriesList.isEmpty()){//如果为空就说明药房现在没有这个批次的库数据
                            //新增药房数据
                            yfDrugObj.setDrugId(ykList.getDrugId());
                            yfDrugObj.setDrugPrescription(yfDruginformation.getDrugPrescription().toString());
                            yfDrugObj.setSupplierId(yfDruginformation.getYkSupplierId());//供应商编号
                            yfDrugObj.setYfDrugcategory(yfDruginformation.getYfDrugcategory());//药品类别
                            yfDrugObj.setYfDrvenBatch(ykList.getYkDrvenBatch());//药品批次编号
                            yfDrugObj.setYfDrvenName(yfDruginformation.getDrugName());//药品名称
                            yfDrugObj.setYfDrvenCount(drugCount);
                            ydtm.insert(yfDrugObj);//新增药房数据
                        }else{
                            //修改药房该批次的库存数量
                            yfDrugObj.setYfDrvenId(yfDruginventoriesList.get(0).getYfDrvenId());
                            yfDrugObj.setYfDrvenCount(yfDruginventoriesList.get(0).getYfDrvenCount()+drugCount);
                            ydtm.updateById(yfDrugObj);//修改药房数据
                        }
                        break;
                    }else{//如果进这里就说明当前这批次的药库库存不足以扣除出库所需的数量 就先减去药库当前这批次的数量 然后继续减
                        drugCount = drugCount - ykList.getYkDrvenCount();
                        //先减药库库存
                        YkDruginventory ykdObj = new YkDruginventory(ykList.getYkDrvenId(),ykList.getYkDrvenCount()-drugCount);
                        dsm.updateById(ykdObj);//修改药库库存

                        //新增出库记录详情表
                        YkStorageDetail ysgdObj = new YkStorageDetail();
                        ysgdObj.setYkStorageId(ykStorageId);
                        ysgdObj.setYkDrvenId(ykList.getYkDrvenId());//药库编号
                        ysgdObj.setYkStorageDetailCount(ykList.getYkDrvenCount());//出库数量
                        ysgdObj.setDrugId(ykList.getDrugId());//药品编号
                        ysgdm.insert(ysgdObj);//新增出库详表记录

                        //先查询药房是否存在这一批次的药品
                        QueryWrapper<YfDruginventory> yfDruginventoryQW = new QueryWrapper<YfDruginventory>()
                                .eq("YF_drven_batch",ykList.getYkDrvenBatch()).eq("drug_id",ykList.getDrugId());
                        List<YfDruginventory> yfDruginventoriesList = ydtm.selectList(yfDruginventoryQW);
                        //根据药品编号查询药品信息
                        YfDruginventory yfDrugObj = new YfDruginventory();
                        YfDruginformation yfDruginformation = difm.selectById(ykList.getDrugId());//药品信息对象
                        if (yfDruginventoriesList.isEmpty()){//如果为空就说明药房现在没有这个批次的库数据
                            //新增药房数据
                            yfDrugObj.setDrugId(ykList.getDrugId());
                            yfDrugObj.setDrugPrescription(yfDruginformation.getDrugPrescription().toString());
                            yfDrugObj.setSupplierId(yfDruginformation.getYkSupplierId());//供应商编号
                            yfDrugObj.setYfDrugcategory(yfDruginformation.getYfDrugcategory());//药品类别
                            yfDrugObj.setYfDrvenBatch(ykList.getYkDrvenBatch());//药品批次编号
                            yfDrugObj.setYfDrvenName(yfDruginformation.getDrugName());//药品名称
                            yfDrugObj.setYfDrvenCount(ykList.getYkDrvenCount());
                            ydtm.insert(yfDrugObj);//新增药房数据
                        }else{
                            //修改药房该批次的库存数量
                            yfDrugObj.setYfDrvenId(yfDruginventoriesList.get(0).getYfDrvenId());
                            yfDrugObj.setYfDrvenCount(yfDruginventoriesList.get(0).getYfDrvenCount()+drugCount);
                            ydtm.updateById(yfDrugObj);//修改药房数据
                        }
                    }
                }
            }
        }

    }

    //生成随机单号
    public static Long getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Long newDate= Long.parseLong(sdf.format(new Date()));
        String result="";
        Random random=new Random();
        for(int i=0;i<5;i++){
            result+=random.nextInt(20);
        }
        return newDate+Long.parseLong(result);
    }

    //查询调拨申请
    public List<YkAllot> allykallot(){
        return ykAllotMapper.allykallot();
    }

    //查询调拨详表
    public List<YkAllotdetail> alldetail(String ykAllotId){
        return ykAllotMapper.alldetail(ykAllotId);
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

        for (YfDruginventory y : ykAllot.getYfDruginventories()) {

           YkAllotdetail a=new YkAllotdetail();
            a.setYkAllotId(allot.getYkAllotId());
           a.setYkDrugId(y.getDrugId());
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
