package cn.gson.hisspring.model.service.pharmacy_module_service;


import cn.gson.hisspring.model.mapper.outpatient_module_mapper.MzRecipeMapper;
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

@Service
@Transactional
public class MzRecipServiceImp {
    @Autowired
    YfMzRecipeMapper mzcipe;//处方单

    @Autowired
    MzRecipeMapper recipeMapper;//处方mapper

    @Autowired
    MzZprescriMapper mzpre;//中药

    @Autowired
    MzXprescriMapper mzxpr;//西药

    @Autowired
    YKStorageMapper ysgm;//出库mapper

    @Autowired
    YkStorageDetailMapper ysgdm;//出库详单mapper

    @Autowired
    YFDruglnventoryMapper ydtm;//药房mapper

    //生成随机单号
    public static Long getOrderIdByTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Long newDate = Long.parseLong(sdf.format(new Date()));
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            result += random.nextInt(20);
        }
        return newDate + Long.parseLong(result);
    }

    //门诊发药
    public void fayao(MzRecipe mzRecipes, Long sId) {
        //生成发药记录的编号
        Long fyStorageId = getOrderIdByTime();

        //新增发药记录的主表
        YkStorage storg = new YkStorage();
        storg.setYkStorageId(fyStorageId);
        storg.setSId(sId);
        storg.setYkStorageCause("药品发药");
        storg.setYkStorageOutorenter(3L);//1表示入库  2表示出库   3表示发药
        ysgm.insert(storg);//新增发药记录的主表

        //修改处方状态
        QueryWrapper qwRe = new QueryWrapper();
        qwRe.eq("recipe_Number", mzRecipes.getRecipeNumber());
        MzRecipe mzRecipe = recipeMapper.selectOne(qwRe);
        if (mzRecipe != null) {
            mzRecipe.setRecipeDrugState(2L);
            recipeMapper.updateById(mzRecipe);

            //西药修改状态
            QueryWrapper qwXp = new QueryWrapper();
            qwXp.eq("recipe_Number", mzRecipe.getRecipeNumber());
            List<MzXprescription> list1 = mzxpr.selectList(qwXp);
            if (!list1.isEmpty()) {
                for (MzXprescription mzXprescription : list1) {
                    mzXprescription.setRdStatePrice(2L);
                    mzxpr.updateById(mzXprescription);
                }
            }
            //中药修改状态
            QueryWrapper qwZp = new QueryWrapper();
            qwZp.eq("recipe_Number", mzRecipe.getRecipeNumber());
            List<MzZprescription> list2 = mzpre.selectList(qwZp);
            if (!list2.isEmpty()) {
                for (MzZprescription mzZprescription : list2) {
                    mzZprescription.setZpStatePrice(2L);
                    mzpre.updateById(mzZprescription);
                }
            }
        }


        //根据处方单查询出需要发出的药品
        //查询中药要发药的药品
        QueryWrapper<MzZprescription> zyyz = new QueryWrapper<MzZprescription>().eq("recipe_Number", mzRecipes.getRecipeNumber());
        List<MzZprescription> mzZprescriptionList = mzpre.selectList(zyyz);
        System.out.println("中药门诊发药" + mzZprescriptionList);
        for (MzZprescription mzzprescription : mzZprescriptionList) {//循环中药门诊发药单
            Long zyfy = mzzprescription.getZpCount();//中药需要发药的数量
            //根据中药处方单编号查询出药房药品集合
            System.err.println(mzzprescription);
            System.err.println(mzzprescription.getDrugId());
            QueryWrapper<YfDruginventory> yfDruginventorQW = new QueryWrapper<YfDruginventory>().eq("drug_id", mzzprescription.getDrugId())
                    .orderByAsc("YF_drven_mftDate");//根据保质期扣库存
            List<YfDruginventory> yfDruginventoryList = ydtm.selectList(yfDruginventorQW);//查询药房所有编号一样的样品数据
            System.err.println(yfDruginventoryList);
            for (YfDruginventory yfList : yfDruginventoryList) {
                if (zyfy <= yfList.getYfDrvenCount() && yfList.getYfDrvenCount() > 0) {//进这个循环就可以扣除库存
                    //扣除药房库存
                    YfDruginventory yfkc = new YfDruginventory(yfList.getYfDrvenId(), yfList.getYfDrvenCount() - zyfy);
                    ydtm.updateById(yfkc);//修改药房库存

                    //新增发药详表记录
                    YkStorageDetail storgdetail = new YkStorageDetail();
                    storgdetail.setYkDrvenId(fyStorageId);
                    storgdetail.setYkDrvenId(yfList.getYfDrvenId());//药房编号
                    storgdetail.setYkStorageDetailCount(zyfy);//发药数量
                    storgdetail.setDrugId(yfList.getDrugId());//药品编号
                    ysgdm.insert(storgdetail);//新增发药详表
                }
            }
        }
        //查询西药要发的药品
        QueryWrapper<MzXprescription> xyyz = new QueryWrapper<MzXprescription>().eq("recipe_Number", mzRecipes.getRecipeNumber());
        List<MzXprescription> mzXprescriptionList = mzxpr.selectList(xyyz);
        System.out.println("西药门诊发药" + mzXprescriptionList);
        for (MzXprescription mzxprescription : mzXprescriptionList) {//循环西药发药单
            Long xyfy = mzxprescription.getRdCount();//西药需要发药的数量
            System.err.println("西药发药数量-------" + xyfy);
            //根据西药处方单编号查询出药房的集合
            QueryWrapper<YfDruginventory> yfDruginventoryqw = new QueryWrapper<YfDruginventory>().eq("drug_id", mzxprescription.getDrugId())
                    .orderByAsc("YF_drven_mftDate");//根据保质期时间来升序查询，先扣时间早的药品
            List<YfDruginventory> yfDruginventories = ydtm.selectList(yfDruginventoryqw);//查询药房所有的编号一样的药品数量
            for (YfDruginventory yflists : yfDruginventories) {
                if (xyfy <= yflists.getYfDrvenCount() && yflists.getYfDrvenCount() > 0) {
                    //扣除药房库存
                    YfDruginventory yfkcc = new YfDruginventory(yflists.getYfDrvenId(), yflists.getYfDrvenCount() - xyfy);
                    ydtm.updateById(yfkcc);//修改药房库存
                    //新增发药详表记录
                    YkStorageDetail storgdetail = new YkStorageDetail();
                    storgdetail.setYkDrvenId(fyStorageId);
                    storgdetail.setYkDrvenId(yflists.getYfDrvenId());//药房编号
                    storgdetail.setYkStorageDetailCount(xyfy);//发药数量
                    storgdetail.setDrugId(yflists.getDrugId());//药品编号
                    ysgdm.insert(storgdetail);//新增发药详表
                }
            }
        }
    }

    //查询已经缴费的处方单
    public List<MzRecipe> allMzRecipe() {
        return mzcipe.allMzRecipess();
    }


}
